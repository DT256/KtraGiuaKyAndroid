package com.giuaky.ktragiuakyapi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.IdentifierAccessor;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
    @Autowired
    private  UserRepository userRepository;

    @Override
    public String register(UserCreateRequest request) {
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(request.getPassword());


        userRepository.save(newUser);

        return "User created";
    }

    @Override
    public UserResponse login(UserLoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (request.getPassword()==user.getPassword()) {
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
