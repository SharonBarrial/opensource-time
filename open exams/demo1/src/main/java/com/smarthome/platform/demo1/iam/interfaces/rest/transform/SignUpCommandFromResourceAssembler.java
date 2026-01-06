package com.smarthome.platform.demo1.iam.interfaces.rest.transform;

import com.smarthome.platform.demo1.iam.domain.model.commands.SignUpCommand;
import com.smarthome.platform.demo1.iam.domain.model.entities.Role;
import com.smarthome.platform.demo1.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

/**
 * Assembler class to convert SignUpResource to SignUpCommand
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

public class SignUpCommandFromResourceAssembler {

    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() != null ? resource.roles().stream().map(name -> Role.toRoleFromName(name)).toList() : new ArrayList<Role>();
        return new SignUpCommand(resource.username(), resource.password(), roles);
    }

}
