package com.giuaky.ktragiuakyandroid.helper;

import android.content.Context;
import android.widget.Toast;

import com.giuaky.ktragiuakyandroid.RetrofitClient;
import com.giuaky.ktragiuakyandroid.dto.OtpApiResponse;
import com.giuaky.ktragiuakyandroid.service.OtpApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpHelper {
    private static OtpApiService otpApiService = RetrofitClient.getRetrofit().create(OtpApiService.class);

    // Hàm gửi OTP, có thể gọi từ bất kỳ Activity nào
    public static void sendOtp(Context context, String email) {
        otpApiService.sendOtp(email).enqueue(new Callback<OtpApiResponse>() {
            @Override
            public void onResponse(Call<OtpApiResponse> call, Response<OtpApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    OtpApiResponse apiResponse = response.body();
                    if (apiResponse.isSuccess()) {
                        Toast.makeText(context, "OTP Sent Successfully!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Failed to Send OTP!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "Server Error!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OtpApiResponse> call, Throwable t) {
                Toast.makeText(context, "Connection Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Hàm xác thực OTP, có thể gọi từ bất kỳ Activity nào
    public static void verifyOtp(Context context, String email, String otp) {
        otpApiService.verifyOtp(email, otp).enqueue(new Callback<OtpApiResponse>() {
            @Override
            public void onResponse(Call<OtpApiResponse> call, Response<OtpApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    OtpApiResponse apiResponse = response.body();
                    if (apiResponse.isSuccess()) {
                        Toast.makeText(context, "OTP Verified!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Invalid OTP!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "Invalid OTP!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OtpApiResponse> call, Throwable t) {
                Toast.makeText(context, "Connection Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
