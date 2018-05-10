package com.backend.technicalchallenge.services.interfaces;

import com.backend.technicalchallenge.model.evaluation.EvaluatedUser;
import com.backend.technicalchallenge.model.user.UserApp;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserApp> getAllUsers();
    List<UserApp> getActiveUsers();
    UserApp setUser(UserApp userApp);
    UserApp getUserById(Long id);
    List<EvaluatedUser> getUserOnEvent(Long idEvent);
    EvaluatedUser getEvaluatedUserById(Long idEvaluatedUser);
    List<EvaluatedUser> getEvaluatedUserForAnEvent(Long idEvent);
}
