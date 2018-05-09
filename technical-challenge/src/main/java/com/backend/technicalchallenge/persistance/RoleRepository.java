package com.backend.technicalchallenge.persistance;


import com.backend.technicalchallenge.model.user.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

    List<Role> findAll();
}
