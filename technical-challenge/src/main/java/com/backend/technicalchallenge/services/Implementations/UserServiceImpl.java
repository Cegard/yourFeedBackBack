package com.backend.technicalchallenge.services.Implementations;

import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.evaluation.EvaluatedUser;
import com.backend.technicalchallenge.model.event.Event;
import com.backend.technicalchallenge.model.user.UserApp;
import com.backend.technicalchallenge.persistance.EvaluatedUserRepository;
import com.backend.technicalchallenge.persistance.EventRepository;
import com.backend.technicalchallenge.persistance.UserRepository;
import com.backend.technicalchallenge.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EvaluatedUserRepository evaluatedUserRepository;


    @Override
    public Optional<UserApp> setUser(UserApp userApp) {
        userRepository.save(userApp);
        return userRepository.findById(userApp.getId());
    }



    @Override
    public List<UserApp> getActiveUsers(){ return userRepository.findByStatus(Status.ACTIVE);}

    @Override
    public List<UserApp> getAllUsers(){ return userRepository.findAll(); }


    @Override
    public UserApp getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    
    @Override
    public List<EvaluatedUser> getEvaluatedUserForAnEvent(Long idEvent) {
        Optional<Event> event = eventRepository.findById(idEvent);
        return evaluatedUserRepository.findAllByEventAndStatus(event, Status.ACTIVE);
    }

    @Override
    public EvaluatedUser getEvaluatedUserById(Long idEvaluatedUser) {
        return evaluatedUserRepository.findById(idEvaluatedUser).get();
    }






}
