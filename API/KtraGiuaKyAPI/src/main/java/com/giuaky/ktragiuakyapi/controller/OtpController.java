package com.giuaky.ktragiuakyapi.controller;

import com.giuaky.ktragiuakyapi.dto.OtpApiResponse;
import com.giuaky.ktragiuakyapi.entity.Otp;
import com.giuaky.ktragiuakyapi.generator.OtpGenerator;
import com.giuaky.ktragiuakyapi.repository.OtpRepository;
import com.giuaky.ktragiuakyapi.service.EmailService;
import com.giuaky.ktragiuakyapi.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Author: 22110400 - Nguyen Hoang Phuc
 */
@RestController
@RequestMapping("/api/otp")
public class OtpController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private OtpService otpService;

    @PostMapping("/send-otp")
    public ResponseEntity<OtpApiResponse> sendOtp(@RequestParam String email) {
        String otp = OtpGenerator.generateOtp();
        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(5); // Thời gian hết hạn OTP

        // Lưu OTP vào cơ sở dữ liệu
        Otp otpRecord = new Otp(email, otp, expirationTime);
        otpService.save(otpRecord);

        // Gửi OTP tới email của người dùng
        emailService.sendOtp(email, otp);

        // Tạo phản hồi JSON
        OtpApiResponse response = new OtpApiResponse(
                true,
                "OTP sent to email successfully",
                null // Không có dữ liệu bổ sung
        );

        return ResponseEntity.ok(response);
    }


}
