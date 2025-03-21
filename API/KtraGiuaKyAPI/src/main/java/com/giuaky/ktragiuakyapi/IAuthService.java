package com.giuaky.ktragiuakyapi;

public interface IAuthService {
	AuthResponse register(UserCreateRequest request);
    AuthResponse login(UserLoginRequest request);
}
