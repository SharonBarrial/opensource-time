package com.library.platform.upc.Iam.domain.services;

import com.library.platform.upc.Iam.domain.model.commands.SeedRolesCommand;
import org.springframework.stereotype.Service;

@Service
public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
