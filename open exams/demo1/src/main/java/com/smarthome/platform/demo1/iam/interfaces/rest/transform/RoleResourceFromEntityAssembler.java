package com.smarthome.platform.demo1.iam.interfaces.rest.transform;

import com.smarthome.platform.demo1.iam.domain.model.entities.Role;
import com.smarthome.platform.demo1.iam.interfaces.rest.resources.RoleResource;

/**
 * Assembler class to convert Role entity to RoleResource
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 **/
public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
