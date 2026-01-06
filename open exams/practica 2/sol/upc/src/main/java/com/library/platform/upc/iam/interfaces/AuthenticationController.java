package com.library.platform.upc.iam.interfaces;


import com.library.platform.upc.iam.domain.model.aggregates.User;
import com.library.platform.upc.iam.domain.model.commands.SignUpCommand;
import com.library.platform.upc.iam.domain.services.UserCommandService;
import com.library.platform.upc.iam.interfaces.rest.resources.AuthenticatedUserResource;
import com.library.platform.upc.iam.interfaces.rest.resources.SignInResource;
import com.library.platform.upc.iam.interfaces.rest.resources.SignUpResource;
import com.library.platform.upc.iam.interfaces.rest.resources.UserResource;
import com.library.platform.upc.iam.interfaces.rest.transform.AuthenticatedUserResourceFromEntityAssembler;
import com.library.platform.upc.iam.interfaces.rest.transform.SignInCommandFromResourceAssembler;
import com.library.platform.upc.iam.interfaces.rest.transform.SignUpCommandFromResourceAssembler;
import com.library.platform.upc.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * AuthenticationController
 * <p>
 *     This controller is responsible for handling authentication requests.
 *     It exposes two endpoints:
 *     <ul>
 *         <li>POST /api/v1/auth/sign-in</li>
 *         <li>POST /api/v1/auth/sign-up</li>
 *     </ul>
 * </p>
 */
@RestController
@RequestMapping(value = "/api/v1/authentication", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Authentication", description = "Authentication Endpoints")
public class AuthenticationController {
    private final UserCommandService userCommandService;

    public AuthenticationController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    /**
     * Handles the sign-in request.
     * @param signInResource the sign-in request body.
     * @return the authenticated user resource.
     */
    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody SignInResource signInResource) {
        var signInCommand = SignInCommandFromResourceAssembler.toCommandFromResource(signInResource);
        Optional<ImmutablePair<User, String>> authenticatedUser;
        try {
            authenticatedUser = userCommandService.handle(signInCommand);
        } catch (Exception e){
            return ResponseEntity
                    .badRequest()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(e.getMessage());
        }
        if (authenticatedUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var authenticatedUserResource = AuthenticatedUserResourceFromEntityAssembler.toResourceFromEntity(authenticatedUser.get().getLeft(), authenticatedUser.get().getRight());
        return ResponseEntity.ok(authenticatedUserResource);
    }

    /**
     * Handles the sign-up request.
     * @param signUpResource the sign-up request body.
     * @return the created user resource.
     */
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignUpResource signUpResource) {
        SignUpCommand signUpCommand;
        try{
            signUpCommand = SignUpCommandFromResourceAssembler.toCommandFromResource(signUpResource);
        }
        catch (Exception e){
            return ResponseEntity
                    .badRequest()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(e.getMessage());
        }

        Optional<User> user;
        try {
            user = userCommandService.handle(signUpCommand);
        } catch (Exception e){
            return ResponseEntity
                    .badRequest()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(e.getMessage());
        }
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);

    }
}