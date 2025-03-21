package com.giuaky.ktragiuakyandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.giuaky.ktragiuakyandroid.dto.SignupRequest;

import java.util.Map;

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

        // Create signup request (giả sử API nhận JSON hoặc form data)
        SignupRequest request = new SignupRequest(name, email, password);
        performSignup(request);
    }

    private void performSignup(SignupRequest request) {
        SignupApiService apiService = RetrofitClient.getRetrofit().create(SignupApiService.class);
        Call<Map<String, String>> call = apiService.signup(request);

        call.enqueue(new Callback<Map<String, String>>() {
            @Override
            public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
                if (response.code() == 201) { // Khớp với HttpStatus.CREATED
                    Map<String, String> responseBody = response.body();
                    if (responseBody != null && responseBody.containsKey("message")) {
                        handleSignupSuccess();
                    } else {
                        showToast("Đăng ký thất bại: Phản hồi không hợp lệ");
                    }
                } else {
                    String errorMsg = response.body() != null ? response.body().toString() : "Lỗi không xác định";
                    showToast("Đăng ký thất bại: " + response.code() + " - " + errorMsg);
                }
            }

            @Override
            public void onFailure(Call<Map<String, String>> call, Throwable t) {
                showToast("Lỗi kết nối: " + t.getMessage());
            }
        });
    }

    // Phương thức xử lý khi đăng ký thành công
    private void handleSignupSuccess() {
        showToast("Đăng ký thành công!");
        navigateToLogin();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void navigateToLogin() {
        Intent intent = new Intent(SignupActivity.this, login.class);
        startActivity(intent);
        finish();
    }

    public void goToLogin(View view) {
        showToast("Chuyển đến màn hình đăng nhập...");
        navigateToLogin();
    }
}