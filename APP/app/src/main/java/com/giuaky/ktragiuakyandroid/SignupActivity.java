package com.giuaky.ktragiuakyandroid;

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
 *  @Version : 1.0
 *  @Created : 21/03/2025
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

        editTextName = findViewById(R.id.editTextTextPassword);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword2);
    }

    public void onRegisterClick(View view) {
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        SignupRequest request = new SignupRequest(name, email, password);

        SignupApiService apiService = RetrofitClient.getRetrofit().create(SignupApiService.class);

        Call<SignupResponse> call = apiService.signup(request);
        call.enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                if (response.isSuccessful()) {
                    SignupResponse signupResponse = response.body();
                    if (signupResponse != null && signupResponse.isSuccess()) {
                        Toast.makeText(SignupActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                        // Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                        // startActivity(intent);
                        // finish();
                    } else {
                        String message = signupResponse != null ? signupResponse.getMessage() : "Đăng ký thất bại";
                        Toast.makeText(SignupActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SignupActivity.this, "Lỗi: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {
                Toast.makeText(SignupActivity.this, "Lỗi mạng: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void goToLogin(View view) {
        Toast.makeText(this, "Chuyển đến màn hình khôi phục mật khẩu...", Toast.LENGTH_SHORT).show();
        // Intent intent = new Intent(this, LoginActivity.class);
        // startActivity(intent);
    }
}