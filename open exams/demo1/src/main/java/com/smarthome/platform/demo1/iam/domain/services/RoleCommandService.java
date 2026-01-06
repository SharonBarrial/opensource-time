package com.smarthome.platform.demo1.iam.domain.services;

import com.smarthome.platform.demo1.iam.domain.model.commands.SeedRolesCommand;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
