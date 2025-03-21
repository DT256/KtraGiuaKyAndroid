package com.giuaky.ktragiuakyapi;

public interface IAuthService {
	String register(UserCreateRequest request);
    UserResponse login(UserLoginRequest request);
}
