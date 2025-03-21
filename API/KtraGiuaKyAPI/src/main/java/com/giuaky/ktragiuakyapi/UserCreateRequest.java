package com.giuaky.ktragiuakyapi;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class UserCreateRequest {
    private String email;
    private String username;
    private String password;
}
