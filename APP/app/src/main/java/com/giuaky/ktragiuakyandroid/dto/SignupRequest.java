package com.giuaky.ktragiuakyandroid.dto;
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
public class SignupRequest {
    private String name;
    private String email;
    private String password;

    public SignupRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getter và Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
