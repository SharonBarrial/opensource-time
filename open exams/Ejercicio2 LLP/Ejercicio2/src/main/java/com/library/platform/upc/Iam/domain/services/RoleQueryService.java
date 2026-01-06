package com.library.platform.upc.Iam.domain.services;

import com.library.platform.upc.Iam.domain.model.entities.Role;
import com.library.platform.upc.Iam.domain.model.queries.GetAllRolesQuery;
import com.library.platform.upc.Iam.domain.model.queries.GetRoleByNameQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRoleByNameQuery query);
}
