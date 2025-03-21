package com.giuaky.ktragiuakyandroid;

import com.giuaky.ktragiuakyandroid.dto.SignupRequest;
import com.giuaky.ktragiuakyandroid.dto.SignupResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
/**
 * ==========================================
 *            PROJECT INFORMATION
 * ==========================================
 *  @Author  : Trần Phi Thắng 🚀
 *  @MSSV    : 22110424
 *  @Version : 1.0
 *  @Created : 21/03/2025
 *
 *  🔥 Code sạch - Chạy mượt - Không bug! 🔥
 */
public interface SignupApiService {
    @POST("api/register")
    Call<SignupResponse> signup(@Body SignupRequest request);
}
