package com.giuaky.ktragiuakyandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.giuaky.ktragiuakyandroid.dto.SignupRequest;
import com.giuaky.ktragiuakyandroid.dto.SignupResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * ==========================================
 *            PROJECT INFORMATION
 * ==========================================
 *  @Author  : Trần Phi Thắng 🚀
 *  @MSSV    : 22110424
 *  @Version : 1.1
 *  @Created : 21/03/2025
 *  @Updated : 20/03/2025
 *
 *  🔥 Code sạch - Chạy mượt - Không bug! 🔥
 */
public class SignupActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize EditText fields
        editTextName = findViewById(R.id.editTextTextPassword); // Ensure this ID matches your layout
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword2);
    }

    public void onRegisterClick(View view) {
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Validate input
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showToast("Vui lòng điền đầy đủ thông tin");
            return;
        }

        // Create signup request
        SignupRequest request = new SignupRequest(name, email, password);
        performSignup(request);
    }

    private void performSignup(SignupRequest request) {
        SignupApiService apiService = RetrofitClient.getRetrofit().create(SignupApiService.class);
        Call<SignupResponse> call = apiService.signup(request);

        call.enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                if (response.isSuccessful()) {
                    SignupResponse signupResponse = response.body();
                    if (signupResponse != null && signupResponse.isSuccess()) {
                        showToast("Đăng ký thành công!");
                        navigateToLogin();
                    } else {
                        String message = signupResponse != null && signupResponse.getMessage() != null
                                ? signupResponse.getMessage()
                                : "Đăng ký thất bại";
                        String errorCode = signupResponse != null && signupResponse.getErrorCode() != null
                                ? " (Mã lỗi: " + signupResponse.getErrorCode() + ")"
                                : "";
                        showToast(message + errorCode);
                    }
                } else {
                    showToast("Lỗi server: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {
                showToast("Lỗi mạng: " + t.getMessage());
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void navigateToLogin() {
        Intent intent = new Intent(SignupActivity.this, login.class); // Assuming class name is "LoginActivity"
        startActivity(intent);
        finish();
    }

    public void goToLogin(View view) {
        showToast("Chuyển đến màn hình đăng nhập...");
        navigateToLogin();
    }
}