package com.giuaky.ktragiuakyandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.giuaky.ktragiuakyandroid.dto.OtpApiResponse;
import com.giuaky.ktragiuakyandroid.dto.OtpRequest;
import com.giuaky.ktragiuakyandroid.helper.OtpHelper;
import com.giuaky.ktragiuakyandroid.service.OtpApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//22110400 Nguyen Hoang Phuc
public class VerifyOtpActivity extends AppCompatActivity {

    private EditText[] otpInputs = new EditText[6]; // 6 ô nhập OTP
    private Button verifyButton;
    private OtpApiService otpApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verify_otp);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        otpInputs[0] = findViewById(R.id.otp1);
        otpInputs[1] = findViewById(R.id.otp2);
        otpInputs[2] = findViewById(R.id.otp3);
        otpInputs[3] = findViewById(R.id.otp4);
        otpInputs[4] = findViewById(R.id.otp5);
        otpInputs[5] = findViewById(R.id.otp6);
        verifyButton = findViewById(R.id.verify_button);

        // Giả sử email được truyền vào qua Intent từ Activity khác
        String email = "phucnguyeho@gmail.com";

        OtpHelper.sendOtp(this, email);

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo OTP từ 6 ô nhập
                StringBuilder otpBuilder = new StringBuilder();
                for (EditText editText : otpInputs) {
                    otpBuilder.append(editText.getText().toString().trim());
                }
                String otp = otpBuilder.toString();

                // Gọi API xác thực OTP thông qua helper
                OtpHelper.verifyOtp(VerifyOtpActivity.this, email, otp);
            }
        });
    }


}