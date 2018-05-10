package com.backend.technicalchallenge.services.interfaces;

import com.backend.technicalchallenge.model.evaluation.Evaluation;

import java.util.List;

public interface EvaluationService {

    boolean saveEvaluation(Evaluation evaluation);
    List<Evaluation> getEvaluations();


}
