package com.petchat.registration.controllers;

import com.petchat.registration.kafka.KafkaAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class AuthController {
    @Autowired
    KafkaAuth kafkaAuth;
    @GetMapping("/hi")
    public String getHi(){
        return "Hi)";
    }
    @GetMapping("/home")
    public String getHome(Principal principal){
        kafkaAuth.sendUserSessionInfo(principal.getName(),"SessionInfo");
        return "redirect:http://localhost:8001/redirect-to-main";
    }
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
    @GetMapping("/api/register")
    public String getRegister(){return "register";}

}
