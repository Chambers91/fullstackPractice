package com.example.fullstackPractice.registration;

import com.example.fullstackPractice.appuser.AppUser;
import com.example.fullstackPractice.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final emailValidator emailValidator;
    @PostMapping
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator
                .test(request.getEmail());
        //if not a valid email, throw an exception
        if(!isValidEmail){
            throw new IllegalStateException("Email not valid");

  }
//        return appUserService.signUpUser(
//               new AppUser(request.getFirstName(),
//                       request.getLastName(),
//                       request.getEmail(),
//                       request.getPassword())
//        );
        return null;}

    }

