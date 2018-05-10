package com.backend.technicalchallenge.restControllers;

import com.backend.technicalchallenge.model.evaluation.EvaluatedUser;
import com.backend.technicalchallenge.model.questionnaire.Question;
import com.backend.technicalchallenge.model.user.Area;
import com.backend.technicalchallenge.model.user.DocumentType;
import com.backend.technicalchallenge.model.user.Role;
import com.backend.technicalchallenge.model.user.UserApp;
import com.backend.technicalchallenge.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    private DocumentTypeService documentTypeService;
    private AreaService areaService;
    private RoleService roleService;
    private UserService userService;
    private QuestionnaireService questionnaireService;

    @Autowired
    public UserController(DocumentTypeService documentTypeService, AreaService areaService, RoleService roleService, UserService userService, QuestionnaireService questionnaireService) {
        this.documentTypeService = documentTypeService;
        this.areaService = areaService;
        this.roleService = roleService;
        this.userService = userService;
        this.questionnaireService = questionnaireService;
    }

    @GetMapping("/getUsers")
    public List<UserApp> getActiveUsers(){
        return userService.getActiveUsers();
    }

    @GetMapping("/getAllUsers")
    public List<UserApp> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getDocumentsType")
    public List<DocumentType> getDocumentsType() {
        return documentTypeService.getDocumentsType();
    }

    @GetMapping("/getAreas")
    public List<Area> getAreas() {
        return areaService.getAreas();
    }

    @GetMapping("/getRoles")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @PostMapping("/setUser")
    public Optional<UserApp> setUser(@RequestBody UserApp userApp) {
        return userService.setUser(userApp);
    }

    @GetMapping("/getUserById/{id}")
    public UserApp getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getEvaluatedUserByEventId/{id}")
    public List<EvaluatedUser> getEvaluatedUserByEventId(@PathVariable("id") Long id) {
        return userService.getEvaluatedUserForAnEvent(id);
    }

    @GetMapping("/getQuestionbyEvent/{id}")
    public List<Question> getQuestionbyEvent(@PathVariable("id") Long id){
        return questionnaireService.getQuestionsOnQuestionnaire(id);
    }

    @GetMapping("/getEvaluatedUserById/{id}")
    public EvaluatedUser getEvaluatedUserById(@PathVariable("id") Long id) {
        return userService.getEvaluatedUserById(id);
    }
}
