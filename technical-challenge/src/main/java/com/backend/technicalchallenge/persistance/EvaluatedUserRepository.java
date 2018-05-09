package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.evaluation.EvaluatedUser;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EvaluatedUserRepository extends PagingAndSortingRepository<EvaluatedUser, Long> {

    List<EvaluatedUser> findAllByEvent_Id(Long eventId);

}
