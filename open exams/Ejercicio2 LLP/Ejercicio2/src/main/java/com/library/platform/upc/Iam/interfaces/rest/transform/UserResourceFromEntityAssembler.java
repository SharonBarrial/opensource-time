package com.library.platform.upc.Iam.interfaces.rest.transform;

import com.library.platform.upc.Iam.domain.model.aggregates.User;
import com.library.platform.upc.Iam.domain.model.entities.Role;
import com.library.platform.upc.Iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(user.getId(), user.getEmail(), roles);
    }
}
