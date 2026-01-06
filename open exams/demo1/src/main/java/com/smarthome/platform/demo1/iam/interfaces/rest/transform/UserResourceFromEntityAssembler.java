package com.smarthome.platform.demo1.iam.interfaces.rest.transform;

import com.smarthome.platform.demo1.iam.domain.model.aggregates.User;
import com.smarthome.platform.demo1.iam.domain.model.entities.Role;
import com.smarthome.platform.demo1.iam.interfaces.rest.resources.UserResource;

/**
 * Assembler class to convert User entity to UserResource
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(user.getId(), user.getUsername(), roles);
    }
}
