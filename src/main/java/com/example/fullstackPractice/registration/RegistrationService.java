package com.example.fullstackPractice.registration;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class RegistrationService {

    @PostMapping
    public String register(RegistrationRequest request) {
        return "it works";
    }
}
