package com.giuaky.ktragiuakyapi.services.Impl;

import com.giuaky.ktragiuakyapi.entity.Otp;
import com.giuaky.ktragiuakyapi.entity.User;
import com.giuaky.ktragiuakyapi.repository.OtpRepository;
import com.giuaky.ktragiuakyapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Author: 22110400 - Nguyen Hoang Phuc
 */
@Service
public class OtpService {

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private UserRepository userRepository;

    Optional<Otp> findTopByEmailOrderByExpirationTimeDesc(String email) {
        return otpRepository.findTopByEmailOrderByExpirationTimeDesc(email);
    }


    public Otp save(Otp otpEntity) {
        return otpRepository.save(otpEntity);
    }

    public boolean verifyOtp(String otp, String email) {
        Optional<Otp> storedOtp = otpRepository.findTopByEmailOrderByExpirationTimeDesc(email);

        if (storedOtp.isPresent()) {
            Otp otpRecord = storedOtp.get();

            // Validate OTP expiration time
            if (otpRecord.getExpirationTime().isBefore(LocalDateTime.now())) {
                return false; // OTP expired
            }

            // Validate OTP match
            if (otpRecord.getOtp().equals(otp)) {
                otpRepository.delete(otpRecord);
                User user = userRepository.findByEmail(email).get();
                user.setActive(true);
                userRepository.save(user);
                return true;
            }
        }
        return false; // OTP not found or invalid
    }


}
