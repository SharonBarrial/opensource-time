package com.smarthome.platform.demo1.iam.interfaces.rest.resources;

import java.util.List;

/**
 * UserResource class to represent the user resource
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public record UserResource(Long id, String username, List<String> roles) {
}
