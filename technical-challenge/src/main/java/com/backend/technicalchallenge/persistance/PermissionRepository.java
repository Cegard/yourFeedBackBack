package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.user.Permission;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long> {
}
