package com.backend.technicalchallenge.services;

import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.user.UserApp;
import com.backend.technicalchallenge.persistance.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserApp setUser(UserApp userApp) {
        userRepository.save(userApp);
        return userApp;
    }

    public List<UserApp> getActiveUsers(){ return userRepository.findByStatus(Status.ACTIVE.toString());}

    @Override
    public List<UserApp> getUsers(){ return userRepository.findAll(); }


    @Override
    public UserApp getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    
}
