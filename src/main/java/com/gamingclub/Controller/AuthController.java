package com.gamingclub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gamingclub.dto.request.SignupRequest;
import com.gamingclub.dto.response.LoginResponse;
import com.gamingclub.Model.User;
import com.gamingclub.Service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignupRequest request) {
        User user = userService.signup(request);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginResponse request) {
        return userService.login(request)
                .map(user -> ResponseEntity.ok("Login successful! Welcome " + user.getName()))
                .orElse(ResponseEntity.status(401).body("Invalid phone number or password"));
    }
}