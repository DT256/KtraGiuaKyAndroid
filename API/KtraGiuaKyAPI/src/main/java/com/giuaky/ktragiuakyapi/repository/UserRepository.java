package com.giuaky.ktragiuakyapi.repository;

import java.util.Optional;

import com.giuaky.ktragiuakyapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
//22110370
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}
