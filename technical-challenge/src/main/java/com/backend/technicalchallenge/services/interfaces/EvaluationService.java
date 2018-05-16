package com.backend.technicalchallenge.services.interfaces;


import com.backend.technicalchallenge.model.evaluation.EvaluatedUser;
import com.backend.technicalchallenge.model.evaluation.Evaluation;
import com.backend.technicalchallenge.model.evaluation.GroupComment;
import com.backend.technicalchallenge.model.questionnaire.Answer;

import java.util.List;
import java.util.Optional;

public interface EvaluationService {

    boolean saveEvaluation(Evaluation evaluation);
    List<Evaluation> getEvaluations();
    Optional<Evaluation> getEvaluationById(Long idEvaluation);
    Optional<Evaluation> getEvaluation(Long  idEvaluation);


    Long persistEvaluation(Long idEvent, Long idEvaluator, Long idEvaluatedUser, String note, List<Answer> answers);

    boolean persistEvaluationGroupComments(Long idEvaluation, List<GroupComment> groupComments);


    List<Object> getScore(Long idEvaluation);
    List<EvaluatedUser> getEvaluatedUserByUserApp(Long idUser);

    List<Object> getAverage(Long idEvaluation);
}
