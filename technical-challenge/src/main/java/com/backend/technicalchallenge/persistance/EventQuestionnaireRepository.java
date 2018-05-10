package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.Type;
import com.backend.technicalchallenge.model.event.Event;
import com.backend.technicalchallenge.model.event.EventQuestionnaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EventQuestionnaireRepository extends PagingAndSortingRepository<EventQuestionnaire, Long> {

    List<EventQuestionnaire> findAllByEventAndStatus(Event event, Status status);
    @Query(value = "SELECT * FROM event_questionnaire eq WHERE eq.event_id = :idEvent ", nativeQuery = true)
    Optional<EventQuestionnaire> findAllUserQuestionnaireByIdEventAndStatus(@Param("idEvent") Long idEvent);
    EventQuestionnaire findById(long idEventQuestionnaire);

}
