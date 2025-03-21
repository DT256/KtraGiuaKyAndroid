package com.giuaky.ktragiuakyapi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	 private final IAuthService authService;

	    public AuthController(IAuthService authService) {
	        this.authService = authService;
	    }

	    @PostMapping("/register")
	    public AuthResponse register(@Valid @RequestBody UserCreateRequest request) {
	        return authService.register(request);
	    }

	    @PostMapping("/login")
	    public AuthResponse login(@Valid @RequestBody UserLoginRequest request) {
	        return authService.login(request);
	    }
}
