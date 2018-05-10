package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.evaluation.EvaluatedUser;
import com.backend.technicalchallenge.model.event.Event;
import com.backend.technicalchallenge.model.user.UserApp;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface EvaluatedUserRepository extends PagingAndSortingRepository<EvaluatedUser, Long> {

    List<EvaluatedUser> findAllByEvent(Optional<Event> eventId);
    Optional<EvaluatedUser> findById(Long id);


}
