package com.library.platform.upc.Iam.application.internal.commandservices;

import com.library.platform.upc.Iam.application.internal.outboundservices.hashing.HashingService;
import com.library.platform.upc.Iam.application.internal.outboundservices.tokens.TokenService;
import com.library.platform.upc.Iam.domain.model.aggregates.User;
import com.library.platform.upc.Iam.domain.model.commands.SignInCommand;
import com.library.platform.upc.Iam.domain.model.commands.SignUpCommand;
import com.library.platform.upc.Iam.domain.services.UserCommandService;
import com.library.platform.upc.Iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.library.platform.upc.Iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;

    private final RoleRepository roleRepository;

    public UserCommandServiceImpl(UserRepository userRepository, @Qualifier("hashingServiceImpl") HashingService hashingService, TokenService tokenService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
        this.roleRepository = roleRepository;
    }


    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (userRepository.existsByEmail(command.email()))
            throw new RuntimeException("Email already exists");
        var roles = command.roles().stream().map(role -> roleRepository.findByName(role.getName()).orElseThrow(() -> new RuntimeException("Role name not found"))).toList();
        var user = new User(command.email(), hashingService.encode(command.password()), roles);
        userRepository.save(user);
        return userRepository.findByEmail(command.email());
    }
    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByEmail(command.email());
        if (user.isEmpty())
            throw new RuntimeException("User not found");
        if (!hashingService.matches(command.password(), user.get().getPassword()))
            throw new RuntimeException("Invalid password");
        var token = tokenService.generateToken(user.get().getEmail());
        return Optional.of(ImmutablePair.of(user.get(), token));
    }
}
