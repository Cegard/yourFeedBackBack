package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.user.DocumentType;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DocumentTypeRepository extends PagingAndSortingRepository<DocumentType, Long> {
    List<DocumentType> findAll();

}
