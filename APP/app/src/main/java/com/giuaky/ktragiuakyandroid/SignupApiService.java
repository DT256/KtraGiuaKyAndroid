package com.giuaky.ktragiuakyandroid;

import com.giuaky.ktragiuakyandroid.dto.SignupRequest;

import java.util.Map;

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
    @POST("api/auth/register")
    Call<Map<String, String>> signup(@Body SignupRequest request);
}
