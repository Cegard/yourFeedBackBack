package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.user.Area;
import com.backend.technicalchallenge.model.user.DocumentType;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AreaRepository extends PagingAndSortingRepository<Area, Long> {
    List<Area> findAll();
}
