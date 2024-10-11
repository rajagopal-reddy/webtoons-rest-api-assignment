package com.webtoons.app.service;

import com.webtoons.app.dto.RegisterRequest;
import com.webtoons.app.model.Role;
import com.webtoons.app.model.User;
import com.webtoons.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


        private final UserRepository userRepository;

        private final PasswordEncoder passwordEncoder;

        public void saveUser(RegisterRequest registerRequest) {
            User user = new User();
            user.setUsername(registerRequest.getUsername());
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

            // Set user authorities/roles
            user.setAuthorities(Collections.singletonList(new Role("ROLE_USER"))); // Example of setting a default role

            userRepository.save(user);
        }
    }

