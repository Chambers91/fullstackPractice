package com.example.fullstackPractice.appuser;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface AppUserRepository {
    Optional<AppUser>findByEmail(String email);
}
