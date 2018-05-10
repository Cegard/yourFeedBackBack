package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.evaluation.Evaluation;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EvaluationRepository extends PagingAndSortingRepository<Evaluation, Long > {


    List<Evaluation> findAll();




}
