package com.backend.technicalchallenge.restControllers;

import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.user.UserApp;
import com.backend.technicalchallenge.model.user.UserSession;
import com.backend.technicalchallenge.persistance.UserRepository;
import com.backend.technicalchallenge.security.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.backend.technicalchallenge.security.Security.generateToken;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping(path = "/helloWorld")
    public String HelloWorld(){

        return "Hello world";

    }

    @PostMapping(path = "/auth/register")
    public UserSession createUser (@RequestBody UserApp user){
        user.setStatus(Status.ACTIVE);
        userRepository.save(user);
        UserApp savedUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if( savedUser != null){
            return generateToken(user).setPassword(user.getPassword()).setId(savedUser.getId());
        }
        return null;

    }

    @PostMapping("/auth/login")
    public UserSession login (@RequestBody Credentials credentials ){
        UserApp user = userRepository.findByEmailAndPassword(credentials.getUsername(), credentials.getPassword());
        if(user == null){
            return null;
        }else{
            return  generateToken(user).setId(user.getId()).setPassword(user.getPassword());
        }



    }





}
