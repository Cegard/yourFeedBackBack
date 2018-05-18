package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.evaluation.EvaluatedUser;
import com.backend.technicalchallenge.model.evaluation.Evaluation;
import com.backend.technicalchallenge.model.evaluation.GroupComment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface EvaluationRepository extends PagingAndSortingRepository<Evaluation, Long > {


    List<Evaluation> findAll();
    Optional<Evaluation> findById(Long id);
    List<Evaluation> findByEvaluatedUser(Optional<EvaluatedUser> evaluatedUser);






}
