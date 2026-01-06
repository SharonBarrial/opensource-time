package com.smarthome.platform.demo1.iam.interfaces.rest.resources;

import java.util.List;

/**
 * SignUpResource class to represent the signup resource
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public record SignUpResource(String username, String password, List<String> roles) {
}
