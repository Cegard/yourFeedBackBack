package com.backend.technicalchallenge.services.Implementations;

import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.user.UserApp;
import com.backend.technicalchallenge.persistance.UserRepository;
import com.backend.technicalchallenge.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<UserApp> getActiveUsers(){ return userRepository.findByStatus(Status.ACTIVE);}

    @Override
    public List<UserApp> getAllUsers(){ return userRepository.findAll(); }


    @Override
    public UserApp getUserById(Long id) {
        return userRepository.findById(id).get();
    }


}
