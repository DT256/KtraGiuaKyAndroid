package com.giuaky.ktragiuakyapi.repository;

import com.giuaky.ktragiuakyapi.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Author: 22110400 - Nguyen Hoang Phuc
 */
@Repository
public interface OtpRepository extends JpaRepository<Otp, Long> {
    Optional<Otp> findTopByEmailOrderByExpirationTimeDesc(String email);
}
