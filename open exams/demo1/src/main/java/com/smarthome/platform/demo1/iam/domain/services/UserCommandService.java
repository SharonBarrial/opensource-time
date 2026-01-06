package com.smarthome.platform.demo1.iam.domain.services;

import com.smarthome.platform.demo1.iam.domain.model.aggregates.User;
import com.smarthome.platform.demo1.iam.domain.model.commands.SignInCommand;
import com.smarthome.platform.demo1.iam.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;

/**
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
public interface UserCommandService {
    Optional<User> handle(SignUpCommand command);
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
}
