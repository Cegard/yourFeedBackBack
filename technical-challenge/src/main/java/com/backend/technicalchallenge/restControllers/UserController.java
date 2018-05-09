package com.backend.technicalchallenge.restControllers;

import com.backend.technicalchallenge.model.user.Area;
import com.backend.technicalchallenge.model.user.DocumentType;
import com.backend.technicalchallenge.model.user.Role;
import com.backend.technicalchallenge.model.user.UserApp;
import com.backend.technicalchallenge.persistance.RoleRepository;
import com.backend.technicalchallenge.persistance.UserRepository;
import com.backend.technicalchallenge.services.AreaService;
import com.backend.technicalchallenge.services.DocumentTypeService;
import com.backend.technicalchallenge.services.RoleService;
import com.backend.technicalchallenge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    public UserController(DocumentTypeService documentTypeService,AreaService areaService,RoleService roleService, UserService userService) {
        this.documentTypeService = documentTypeService;
        this.areaService = areaService;
        this.roleService = roleService;
        this.userService = userService;
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
    public UserApp getUser(@RequestBody UserApp userApp) {
        return userService.setUser(userApp);
    }

    @GetMapping("/getuserById/{id}")
    public UserApp getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
}
