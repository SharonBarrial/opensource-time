package com.smarthome.platform.demo1.iam.interfaces.rest.transform;

import com.smarthome.platform.demo1.iam.domain.model.aggregates.User;
import com.smarthome.platform.demo1.iam.interfaces.rest.resources.AuthenticatedUserResource;

/**
 * Assembler class to convert User to AuthenticatedUserResource
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}
