package com.library.platform.upc.Iam.domain.services;

import com.library.platform.upc.Iam.domain.model.aggregates.User;
import com.library.platform.upc.Iam.domain.model.commands.SignInCommand;
import com.library.platform.upc.Iam.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserCommandService {
    Optional<User> handle(SignUpCommand command);
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
}
