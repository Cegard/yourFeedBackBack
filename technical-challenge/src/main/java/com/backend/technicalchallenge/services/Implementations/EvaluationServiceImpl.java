package com.backend.technicalchallenge.services.Implementations;

import com.backend.technicalchallenge.model.evaluation.Evaluation;
import com.backend.technicalchallenge.persistance.EvaluationRepository;
import com.backend.technicalchallenge.services.interfaces.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;


    @Override
    public boolean saveEvaluation(Evaluation evaluation) {
         evaluationRepository.save(evaluation);
         return true;
    }

    @Override
    public List<Evaluation> getEvaluations() {
        return evaluationRepository.findAll();
    }

    @Override
    public Optional<Evaluation> getEvaluationById(Long idEvaluation) {
        return evaluationRepository.findById(idEvaluation);
    }

}
