package com.giuaky.ktragiuakyandroid.dto;
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
public class SignupResponse {
    private boolean success;
    private String message;
    private String errorCode; // Added for better error handling

    // Constructors
    public SignupResponse() {
    }

    public SignupResponse(boolean success, String message, String errorCode) {
        this.success = success;
        this.message = message;
        this.errorCode = errorCode;
    }

    // Getters and Setters
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

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}