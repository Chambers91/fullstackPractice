package com.example.fullstackPractice.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//implements an interface for Spring Security
@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {


    private final static String USER_NOT_FOUND_MSG =
            "User with email %s not found";
    private final AppUserRepository appUserRepository(){
        return this.appUserRepository();
    };
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository().findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format(USER_NOT_FOUND_MSG, email)));

    }
}
