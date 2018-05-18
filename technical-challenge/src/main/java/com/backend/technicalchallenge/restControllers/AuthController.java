package com.backend.technicalchallenge.restControllers;

import com.backend.technicalchallenge.model.user.UserApp;
import com.backend.technicalchallenge.model.user.UserSession;
import com.backend.technicalchallenge.persistance.UserRepository;
import com.backend.technicalchallenge.security.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.backend.technicalchallenge.security.Security.generateToken;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/auth/register")
    public ResponseEntity<Object> createUser (@RequestBody UserApp user){

        Pattern p = Pattern.compile("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{3,6}$");
        Matcher m = p.matcher(user.getEmail());

        if (!m.find())
        {
            return new ResponseEntity<>("The email is invalid", new HttpHeaders(), HttpStatus.BAD_REQUEST);

        }else{

            p = Pattern.compile("^(?=.*[A-Z]).{3,}$");
            if(!p.matcher(user.getPassword()).find()){
                return new ResponseEntity<>("The password must contain at least one capital letter", new HttpHeaders(), HttpStatus.BAD_REQUEST);
            }
            if(!Pattern.compile("^(?=.*[0-9]).{3,}$").matcher(user.getPassword()).find()){
                return new ResponseEntity<>("The password must contain a number", new HttpHeaders(), HttpStatus.BAD_REQUEST);
            }
            if(user.getName() == null || user.getEmail() == null || user.getPassword() == null || user.getLastName() == null ){
                return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
            }else{
                userRepository.save(user);
                UserApp savedUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
                if( savedUser != null){
                    return new ResponseEntity(generateToken(user).setPassword(user.getPassword()).setId(savedUser.getId()), new HttpHeaders(), HttpStatus.OK);
                }
                return new ResponseEntity<>("Something went wrong on database", new HttpHeaders(), HttpStatus.OK);
            }

        }


    }

    @PostMapping("/auth/login")
    public ResponseEntity<Object> login (@RequestBody Credentials credentials ){

        if(credentials.getPassword() == null && credentials.getUsername() == null){
            return new ResponseEntity<>( "Please fill all mandatory fields", new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
        UserApp user = userRepository.findByEmailAndPassword(credentials.getUsername(), credentials.getPassword());
        if(user == null){
            return new ResponseEntity("The email and password do not match", new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }else{
            return  new ResponseEntity(generateToken(user).setId(user.getId()).setPassword(user.getPassword()), new HttpHeaders(), HttpStatus.OK);
        }



    }





}
