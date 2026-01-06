package com.library.platform.upc.Iam.interfaces.rest.transform;

import com.library.platform.upc.Iam.domain.model.entities.Role;
import com.library.platform.upc.Iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
