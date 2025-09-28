package com.gamingclub.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamingclub.dto.request.SignupRequest;
import com.gamingclub.dto.response.LoginResponse;
import com.gamingclub.Model.User;
import com.gamingclub.repository.UserRepository;

import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User signup(SignupRequest request) {
        User user = new User();
        user.setName(request.name);
        user.setPhone(request.phone);
        user.setPassword(request.password); // ⚠️ Ideally, hash the password
        return userRepository.save(user);
    }

    public Optional<User> login(LoginResponse request) {
        return userRepository.findByPhone(request.phone)
                .filter(user -> user.getPassword().equals(request.password));
    }
}