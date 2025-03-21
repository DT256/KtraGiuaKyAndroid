package com.giuaky.ktragiuakyapi;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequest {
	 private String username;

	 private String password;
}
