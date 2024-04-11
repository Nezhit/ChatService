package com.petchat.registration.controllers;

import com.petchat.registration.controllers.api.RegisterApi;
import com.petchat.registration.dto.RegisterRequest;
import com.petchat.registration.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController implements RegisterApi {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<?> registerUser(RegisterRequest registerRequest) {
        return userService.registerUser(registerRequest);
    }
}
