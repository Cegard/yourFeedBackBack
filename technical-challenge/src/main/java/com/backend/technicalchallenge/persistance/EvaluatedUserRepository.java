package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.evaluation.EvaluatedUser;
import com.backend.technicalchallenge.model.event.Event;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface EvaluatedUserRepository extends PagingAndSortingRepository<EvaluatedUser, Long> {

    List<EvaluatedUser> findAllByEventAndStatus(Optional<Event> eventId, Status status);
    List<EvaluatedUser> findAll();



}
