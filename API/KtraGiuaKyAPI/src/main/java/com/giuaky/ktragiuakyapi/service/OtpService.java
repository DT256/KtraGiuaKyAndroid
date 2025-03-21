package com.giuaky.ktragiuakyapi.service;

import com.giuaky.ktragiuakyapi.entity.Otp;
import com.giuaky.ktragiuakyapi.repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OtpService {

    @Autowired
    private OtpRepository otpRepository;

    Optional<Otp> findTopByEmailOrderByExpirationTimeDesc(String email) {
        return otpRepository.findTopByEmailOrderByExpirationTimeDesc(email);
    }


    public Otp save(Otp otpEntity) {
        return otpRepository.save(otpEntity);
    }
}
