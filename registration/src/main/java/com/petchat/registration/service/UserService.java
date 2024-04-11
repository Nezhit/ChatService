package com.petchat.registration.service;

import com.petchat.registration.dto.RegisterRequest;
import com.petchat.registration.entity.Role;
import com.petchat.registration.entity.User;
import com.petchat.registration.repository.RoleRepo;
import com.petchat.registration.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    public UserService(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    public ResponseEntity<?> registerUser(RegisterRequest registerRequest){
        User user=new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setUsername(registerRequest.getUsername());
        Set<Role> roles=new HashSet<Role>();
        for(Role role:registerRequest.getRoles()){
            roles.add(roleRepo.findRoleByName(role.getName()));
        }
        user.setRoles(roles);
        userRepo.save(user);
        return ResponseEntity.ok("User registered");
    }
}
