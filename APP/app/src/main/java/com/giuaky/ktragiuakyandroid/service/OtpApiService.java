package com.giuaky.ktragiuakyandroid.service;

import com.giuaky.ktragiuakyandroid.dto.OtpApiResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Author: 22110400 - Nguyen Hoang Phuc
 */
public interface  OtpApiService {
    @POST("api/otp/send-otp")
    Call<OtpApiResponse> sendOtp(@Query("email") String email);

    @POST("api/otp/verify-otp")
    Call<OtpApiResponse> verifyOtp(@Query("email") String email, @Query("otp") String otp);
}
