package com.smarthome.platform.demo1.iam.domain.services;

import com.smarthome.platform.demo1.iam.domain.model.entities.Role;
import com.smarthome.platform.demo1.iam.domain.model.queries.GetAllRolesQuery;
import com.smarthome.platform.demo1.iam.domain.model.queries.GetRoleByNameQuery;

import java.util.List;
import java.util.Optional;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRoleByNameQuery query);
}
