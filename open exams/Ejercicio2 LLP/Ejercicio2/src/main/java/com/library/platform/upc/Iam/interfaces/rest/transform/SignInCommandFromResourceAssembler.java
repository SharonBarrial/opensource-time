package com.library.platform.upc.Iam.interfaces.rest.transform;

import com.library.platform.upc.Iam.domain.model.commands.SignInCommand;
import com.library.platform.upc.Iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.email(), signInResource.password());
    }
}
