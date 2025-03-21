package com.giuaky.ktragiuakyapi.generator;

import java.util.Random;

/**
 * Author: 22110400 - Nguyen Hoang Phuc
 */
public class OtpGenerator {
    public static String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // Generate a 6-digit number
        return String.valueOf(otp);
    }
}
