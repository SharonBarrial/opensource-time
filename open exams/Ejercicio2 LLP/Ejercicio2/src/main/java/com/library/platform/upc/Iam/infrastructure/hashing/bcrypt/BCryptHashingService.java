package com.library.platform.upc.Iam.infrastructure.hashing.bcrypt;

import com.library.platform.upc.Iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
