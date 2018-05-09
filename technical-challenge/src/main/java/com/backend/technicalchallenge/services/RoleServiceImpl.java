package com.backend.technicalchallenge.services;

import com.backend.technicalchallenge.model.user.DocumentType;
import com.backend.technicalchallenge.model.user.Role;
import com.backend.technicalchallenge.persistance.DocumentTypeRepository;
import com.backend.technicalchallenge.persistance.RoleRepository;
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
