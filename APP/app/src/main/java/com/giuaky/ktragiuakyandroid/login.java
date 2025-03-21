package com.giuaky.ktragiuakyandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.giuaky.ktragiuakyandroid.network.ApiServiceLogin;
import com.giuaky.ktragiuakyandroid.network.LoginRequest;
import com.giuaky.ktragiuakyandroid.network.LoginRespone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//Pham Trung Ky 22110361
public class login extends AppCompatActivity {
    EditText edt_activity_main_email;
    EditText edt_activity_main_password;
    TextView regiter;
    ImageView imageView;
    SharedPreferences sharedPreferences; // Thêm SharedPreferences

    private static final String PREF_NAME = "UserPrefs"; // Tên file SharedPreferences

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        imageView = findViewById(R.id.imageView);
        // Khởi tạo SharedPreferences
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        AnhXa();

        // Sự kiện click vào "Register"
        regiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        // Sự kiện click vào "Login" (ImageView)
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edt_activity_main_email.getText().toString().trim();
                String password = edt_activity_main_password.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(login.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }

                ApiServiceLogin apiService = RetrofitClient.getRetrofit().create(ApiServiceLogin.class);
                LoginRequest loginRequest = new LoginRequest(username, password);

                Call<LoginRespone> call = apiService.login(loginRequest); // Sửa Response thành LoginRespone trực tiếp
                call.enqueue(new Callback<LoginRespone>() {
                    @Override
                    public void onResponse(Call<LoginRespone> call, Response<LoginRespone> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            LoginRespone loginResponse = response.body();

                            // Lưu thông tin vào SharedPreferences
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("email", loginResponse.getEmail());
                            editor.putString("fullName", loginResponse.getFullName());
                            editor.putString("username", loginResponse.getUsername());
                            editor.putString("urlAvatar", loginResponse.getUrlAvatar());
                            editor.apply();

                            // Chuyển sang MainActivity
                            Intent intent = new Intent(login.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(login.this, "Đăng nhập thất bại! Kiểm tra lại thông tin", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginRespone> call, Throwable t) {
                        Toast.makeText(login.this, "Lỗi kết nối: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void AnhXa() {
        edt_activity_main_email = findViewById(R.id.edt_activity_main_email);
        edt_activity_main_password = findViewById(R.id.edt_activity_main_password);
        regiter = findViewById(R.id.login_register);
        imageView = findViewById(R.id.imageView);
    }
}