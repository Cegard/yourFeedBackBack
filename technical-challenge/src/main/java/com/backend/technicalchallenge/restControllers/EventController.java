package com.backend.technicalchallenge.restControllers;


import com.backend.technicalchallenge.model.event.Event;
import com.backend.technicalchallenge.services.Implementations.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class EventController {


    private EventServiceImpl eventService;

    @Autowired
    public EventController(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/getEvents")
    public List<Event> getEvents() {
        return eventService.getEventsByStatusActive();
    }

    @GetMapping("/getEventById/{id}")
    public Optional<Event> getUserByid(@PathVariable("id") Long id) {
        return eventService.getEventId(id);
    }
}
