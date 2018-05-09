package com.backend.technicalchallenge.services;

import com.backend.technicalchallenge.model.user.UserApp;

import java.util.List;

public interface UserService {

    List<UserApp> getUsers();
    UserApp setUser(UserApp userApp);
    UserApp getUserById(Long id);
}
