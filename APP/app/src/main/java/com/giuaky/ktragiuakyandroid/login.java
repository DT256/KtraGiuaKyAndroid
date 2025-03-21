package com.giuaky.ktragiuakyandroid;

import android.content.Intent;
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
import com.giuaky.ktragiuakyandroid.network.RetrofitClientLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {
    EditText edt_activity_main_email;
    EditText edt_activity_main_password;
    TextView regiter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        AnhXa();

        // Sự kiện click vào "Register"
        regiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, SignupActivity.class);
                startActivity(intent); // Fix lỗi thiếu startActivity()
            }
        });

        // Sự kiện click vào "Login" (ImageView)
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edt_activity_main_email.getText().toString();
                String password = edt_activity_main_password.getText().toString();
                ApiServiceLogin apiService = RetrofitClientLogin.getRetrofit().create(ApiServiceLogin.class);
                LoginRequest loginRequest = new LoginRequest(username, password);

                Call<Response<LoginRespone>> call = apiService.login(loginRequest);
                call.enqueue(new Callback<Response<LoginRespone>>() {
                    @Override
                    public void onResponse(Call<Response<LoginRespone>> call, Response<Response<LoginRespone>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            LoginRespone loginResponse = response.body().body();
                            Toast.makeText(login.this, "Login thành công! Token: " + loginResponse.getToken(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(login.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(login.this, "Đăng nhập thất bại!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Response<LoginRespone>> call, Throwable t) {
                        Toast.makeText(login.this, "Lỗi: " + t.getMessage(), Toast.LENGTH_SHORT).show();
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
