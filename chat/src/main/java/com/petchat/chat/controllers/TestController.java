package com.petchat.chat.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("redirect-to-main")
    public ResponseEntity<?> getUsername() {
        return ResponseEntity.ok("ahahahahahhahahah");
    }

}
