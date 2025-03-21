package com.giuaky.ktragiuakyapi.controller;

import com.giuaky.ktragiuakyapi.services.IAuthService;
import com.giuaky.ktragiuakyapi.dto.UserCreateRequest;
import com.giuaky.ktragiuakyapi.dto.UserLoginRequest;
import com.giuaky.ktragiuakyapi.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	 private IAuthService authService;

	//Tran Phi Thang  22110424
	@PostMapping("/register")
	public ResponseEntity<Map<String, String>> register(@Valid @RequestBody UserCreateRequest request) {
		Map<String, String> response = new HashMap<>();
		response.put("message", authService.register(request));
		return new ResponseEntity<>(response, HttpStatus.CREATED); // Sửa thành HttpStatus.CREATED (201)
	}

	//Ho Le Tan Loi  22110370
	@PostMapping("/login")
	public ResponseEntity<UserResponse> login(@Valid @RequestBody UserLoginRequest request) {
		return new ResponseEntity<>(authService.login(request), HttpStatus.OK);
	}
}
