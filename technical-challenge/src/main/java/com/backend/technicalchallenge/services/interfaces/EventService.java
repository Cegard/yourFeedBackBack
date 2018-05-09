package com.backend.technicalchallenge.services.interfaces;

import com.backend.technicalchallenge.model.event.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    Optional<Event> getEventId(Long id);
    List<Event> getEventsByStatusActive();
}
