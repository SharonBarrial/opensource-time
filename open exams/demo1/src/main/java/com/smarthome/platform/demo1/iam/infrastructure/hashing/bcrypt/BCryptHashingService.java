package com.smarthome.platform.demo1.iam.infrastructure.hashing.bcrypt;

import com.smarthome.platform.demo1.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * This interface is a marker interface for the BCrypt hashing service.
 * It extends the {@link HashingService} and {@link PasswordEncoder} interfaces.
 * This interface is used to inject the BCrypt hashing service in the {@link com.smarthome.platform.demo1.iam.infrastructure.hashing.bcrypt.services.HashingServiceImpl} class.
 * @author Sharon Antuanet Ivet Barrial Marin - u201711490
 * @version 1.0
 */
public interface BCryptHashingService extends HashingService, PasswordEncoder {

}
