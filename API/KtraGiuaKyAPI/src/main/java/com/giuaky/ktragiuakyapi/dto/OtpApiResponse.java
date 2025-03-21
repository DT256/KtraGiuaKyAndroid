package com.giuaky.ktragiuakyapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: 22110400 - Nguyen Hoang Phuc
 */
public class OtpApiResponse {
    private boolean success; // Trạng thái thành công
    private String message;  // Thông báo
    private Object data;     // Dữ liệu trả về (có thể null)

    public OtpApiResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
