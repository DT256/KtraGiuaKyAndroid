package com.giuaky.ktragiuakyandroid.dto;

/**
 * Author: 22110400 - Nguyen Hoang Phuc
 */
public class OtpApiResponse {
    private boolean success;
    private String message;
    private Object data; // Có thể là null

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}

