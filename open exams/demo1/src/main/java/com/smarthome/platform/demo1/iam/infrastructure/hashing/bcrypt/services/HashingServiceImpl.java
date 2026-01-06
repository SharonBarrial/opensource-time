package com.smarthome.platform.demo1.iam.infrastructure.hashing.bcrypt.services;

import com.smarthome.platform.demo1.iam.infrastructure.hashing.bcrypt.BCryptHashingService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * This class implements the {@link BCryptHashingService} interface.
 * It is used to hash passwords using the BCrypt algorithm.
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */
@Service
public class HashingServiceImpl implements BCryptHashingService {
    private final BCryptPasswordEncoder passwordEncoder;

    public HashingServiceImpl() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * Hash a password using the BCrypt algorithm
     *
     * @param rawPassword the password to hash
     * @return String the hashed password
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    /**
     * Check if a raw password matches a hashed password
     *
     * @param rawPassword     the raw password
     * @param encodedPassword the hashed password
     * @return boolean true if the raw password matches the hashed password, false otherwise
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
