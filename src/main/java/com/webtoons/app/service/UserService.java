package com.webtoons.app.service;

import com.webtoons.app.dto.RegisterRequest;
import com.webtoons.app.model.User;

public interface UserService {
    void saveUser(RegisterRequest registerRequest);
}
