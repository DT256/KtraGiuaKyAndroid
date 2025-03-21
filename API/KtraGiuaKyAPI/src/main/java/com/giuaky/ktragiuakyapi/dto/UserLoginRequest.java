package com.giuaky.ktragiuakyapi.dto;

import lombok.Getter;
import lombok.Setter;

//Ho Le Tan Loi 22110370
public class UserLoginRequest {
	 private String username;

	public String getUsername() {
		return username;
	}

	public UserLoginRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;
}
