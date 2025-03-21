package com.giuaky.ktragiuakyapi.services;

import com.giuaky.ktragiuakyapi.dto.UserCreateRequest;
import com.giuaky.ktragiuakyapi.dto.UserLoginRequest;
import com.giuaky.ktragiuakyapi.dto.UserResponse;

public interface IAuthService {
	String register(UserCreateRequest request);
    UserResponse login(UserLoginRequest request);
}
