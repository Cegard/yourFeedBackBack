package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.event.Event;
import com.backend.technicalchallenge.model.event.EventQuestionnaire;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EventQuestionnaireRepository extends PagingAndSortingRepository<EventQuestionnaire, Long> {

    List<EventQuestionnaire> findAllByEventAndStatus(Event event, Status status);

}
