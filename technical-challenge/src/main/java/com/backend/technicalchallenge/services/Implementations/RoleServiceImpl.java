package com.backend.technicalchallenge.services.Implementations;

import com.backend.technicalchallenge.model.user.Role;
import com.backend.technicalchallenge.persistance.RoleRepository;
import com.backend.technicalchallenge.services.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
