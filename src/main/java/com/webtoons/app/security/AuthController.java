package com.webtoons.app.security;

import com.webtoons.app.dto.RegisterRequest;
import com.webtoons.app.security.JwtUtil;
import com.webtoons.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    private final UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody RegisterRequest authRequest) throws AuthenticationException {
        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        // Generate JWT Token after successful authentication
        String jwt = jwtUtil.generateToken(authentication.getName());
        return jwt;
    }

    // You can implement registration logic here
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest) {
        // Save the new user (this method should be implemented in the UserService)
        userService.saveUser(registerRequest);
        return "User registered successfully!";
    }
}
