package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.questionnaire.Answer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AnswerRepository extends PagingAndSortingRepository<Answer, Long> {

    List<Answer> findAllByStatus(Status status);

}
