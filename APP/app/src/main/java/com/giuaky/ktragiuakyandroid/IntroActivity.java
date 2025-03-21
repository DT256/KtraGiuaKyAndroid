package com.giuaky.ktragiuakyandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Tên: Nguyen Hoai Tan
// MSSV: 22110413
public class IntroActivity extends AppCompatActivity {
    private static final String PREF_NAME = "UserPrefs"; // Tên file SharedPreferences, phải giống với login activity
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intro);

        // Khởi tạo SharedPreferences
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        // Kiểm tra xem có username trong SharedPreferences không
        String username = sharedPreferences.getString("username", null);
//        if (username != null) {
//            // Nếu có username, chuyển thẳng sang MainActivity
//            Intent intent = new Intent(IntroActivity.this, MainActivity.class);
//            startActivity(intent);
//            finish(); // Đóng IntroActivity để không quay lại
//            return; // Thoát khỏi onCreate để không thực hiện các bước tiếp theo
//        }

        // Nếu không có username, tiếp tục hiển thị IntroActivity
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang login activity
                Intent intent = new Intent(IntroActivity.this, login.class);
                startActivity(intent);
                finish(); // Đóng IntroActivity sau khi chuyển sang login
            }
        });
    }
}

// Tên: Nguyen Hoai Tan
// MSSV: 22110413