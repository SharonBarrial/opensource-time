package com.smarthome.platform.demo1.iam.domain.services;

import com.smarthome.platform.demo1.iam.domain.model.aggregates.User;
import com.smarthome.platform.demo1.iam.domain.model.queries.GetAllUsersQuery;
import com.smarthome.platform.demo1.iam.domain.model.queries.GetUserByIdQuery;
import com.smarthome.platform.demo1.iam.domain.model.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;

/**
 * UserQueryService interface
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByUsernameQuery query);
}
