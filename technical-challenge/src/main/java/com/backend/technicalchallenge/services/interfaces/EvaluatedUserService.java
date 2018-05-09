package com.backend.technicalchallenge.services.interfaces;


import com.backend.technicalchallenge.model.evaluation.EvaluatedUser;
import com.backend.technicalchallenge.model.questionnaire.Question;
import com.backend.technicalchallenge.model.questionnaire.Questionnaire;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EvaluatedUserService {

    List<EvaluatedUser> getEvaluatedUserForAnEvent(Long idEvent);
    List<Questionnaire> getEventQuestionnaire(Long idEvent);
    List<Question> getQuestionsOnQuestionnaire(Long idQuestionnaire);

}
