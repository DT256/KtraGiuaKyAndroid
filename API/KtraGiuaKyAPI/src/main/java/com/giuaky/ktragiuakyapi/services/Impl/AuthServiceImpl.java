package com.giuaky.ktragiuakyapi.services.Impl;

import java.util.Optional;

import com.giuaky.ktragiuakyapi.repository.UserRepository;
import com.giuaky.ktragiuakyapi.entity.User;
import com.giuaky.ktragiuakyapi.services.IAuthService;
import com.giuaky.ktragiuakyapi.dto.UserCreateRequest;
import com.giuaky.ktragiuakyapi.dto.UserLoginRequest;
import com.giuaky.ktragiuakyapi.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
    @Autowired
    private UserRepository userRepository;

    //Tran Phi Thang 22110424
    @Override
    public String register(UserCreateRequest request) {
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered");
        }
        User newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(request.getPassword());
        newUser.setActive(false);
        newUser.setUsername(request.getUsername());
        userRepository.save(newUser);
        return "User created";
    }

    @Override
    public UserResponse login(UserLoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
        if(!user.isActive()) {
            throw new RuntimeException("User is not active");
        }
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }
        UserResponse  userResponse = new UserResponse();
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setUrlAvatar(userResponse.getUrlAvatar());
        userResponse.setFullName(user.getFullName());

        return userResponse;
    }
}
