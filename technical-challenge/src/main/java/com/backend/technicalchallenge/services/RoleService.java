package com.backend.technicalchallenge.services;

import com.backend.technicalchallenge.model.user.DocumentType;
import com.backend.technicalchallenge.model.user.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
}
