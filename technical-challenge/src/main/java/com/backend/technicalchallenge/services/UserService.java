package com.backend.technicalchallenge.services;

import com.backend.technicalchallenge.model.user.UserApp;

public interface UserService {
    UserApp setUser(UserApp userApp);
    UserApp getUserById(Long id);
}
