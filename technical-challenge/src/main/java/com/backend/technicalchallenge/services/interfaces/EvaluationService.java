package com.backend.technicalchallenge.services.interfaces;

import com.backend.technicalchallenge.model.evaluation.Evaluation;

import java.util.List;
import java.util.Optional;

public interface EvaluationService {

    boolean saveEvaluation(Evaluation evaluation);
    List<Evaluation> getEvaluations();
    Optional<Evaluation> getEvaluationById(Long idEvaluation);


}
