package com.library.platform.upc.Iam.domain.model.commands;


import com.library.platform.upc.Iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String email, String password, List<Role> roles) {
}
