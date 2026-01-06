package com.smarthome.platform.demo1.iam.interfaces.rest.transform;

import com.smarthome.platform.demo1.iam.domain.model.commands.SignInCommand;
import com.smarthome.platform.demo1.iam.interfaces.rest.resources.SignInResource;

/**
 * Assembler class to convert SignInResource to SignInCommand
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}
