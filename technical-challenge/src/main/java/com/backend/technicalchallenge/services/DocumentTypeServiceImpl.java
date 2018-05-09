package com.backend.technicalchallenge.services;

import com.backend.technicalchallenge.model.user.DocumentType;
import com.backend.technicalchallenge.persistance.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {
    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Override
    public List<DocumentType> getDocumentsType() {
        return documentTypeRepository.findAll();
    }
}
