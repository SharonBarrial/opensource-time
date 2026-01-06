package com.library.platform.upc.Iam.application.internal.commandservices;


import com.library.platform.upc.Iam.domain.model.commands.SeedRolesCommand;
import com.library.platform.upc.Iam.domain.model.entities.Role;
import com.library.platform.upc.Iam.domain.model.valueobjects.Roles;
import com.library.platform.upc.Iam.domain.services.RoleCommandService;
import com.library.platform.upc.Iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleCommandServiceImpl implements RoleCommandService {
    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void handle(SeedRolesCommand command) {
        Arrays.stream(Roles.values()).forEach(role -> {
            if(!roleRepository.existsByName(role)) {
                roleRepository.save(new Role(Roles.valueOf(role.name())));
            }
        } );
    }
}
