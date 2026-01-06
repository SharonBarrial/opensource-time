package com.library.platform.upc.Iam.domain.services;

import com.library.platform.upc.Iam.domain.model.aggregates.User;
import com.library.platform.upc.Iam.domain.model.queries.GetAllUsersQuery;
import com.library.platform.upc.Iam.domain.model.queries.GetUserByEmailQuery;
import com.library.platform.upc.Iam.domain.model.queries.GetUserByIdQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByEmailQuery query);

}
