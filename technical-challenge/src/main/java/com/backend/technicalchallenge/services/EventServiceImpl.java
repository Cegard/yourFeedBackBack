package com.backend.technicalchallenge.services;

import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.event.Event;
import com.backend.technicalchallenge.persistance.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;


    public List<Event> getEvents() { return eventRepository.findAll(); }

    public Optional<Event> getEventId(Long id) {
        return eventRepository.findById(id);
    }

    public List<Event> getEventsByStatusActive() {
        return eventRepository.findAllByStatus(Status.ACTIVE.toString());
    }

}
