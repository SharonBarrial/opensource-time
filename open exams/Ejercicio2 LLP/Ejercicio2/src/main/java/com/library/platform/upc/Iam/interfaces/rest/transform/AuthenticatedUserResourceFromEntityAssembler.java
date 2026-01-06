package com.library.platform.upc.Iam.interfaces.rest.transform;

import com.library.platform.upc.Iam.domain.model.aggregates.User;
import com.library.platform.upc.Iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getEmail(), token);
    }
}
