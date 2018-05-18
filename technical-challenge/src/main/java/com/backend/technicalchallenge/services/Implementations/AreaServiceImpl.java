package com.backend.technicalchallenge.services.Implementations;

import com.backend.technicalchallenge.model.user.Area;
import com.backend.technicalchallenge.persistance.AreaRepository;
import com.backend.technicalchallenge.services.interfaces.AreaService;
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
