package com.backend.technicalchallenge.services;

import com.backend.technicalchallenge.model.user.Area;
import com.backend.technicalchallenge.model.user.DocumentType;
import com.backend.technicalchallenge.persistance.AreaRepository;
import com.backend.technicalchallenge.persistance.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<Area> getAreas() {
        return areaRepository.findAll();
    }
}
