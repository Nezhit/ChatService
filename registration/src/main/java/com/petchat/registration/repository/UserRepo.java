package com.petchat.registration.repository;

import com.petchat.registration.entity.User;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
