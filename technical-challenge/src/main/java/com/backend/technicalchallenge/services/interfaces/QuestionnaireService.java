package com.backend.technicalchallenge.services.interfaces;


import com.backend.technicalchallenge.model.questionnaire.GroupApp;
import com.backend.technicalchallenge.model.questionnaire.Question;

import java.util.List;
import java.util.Optional;


public interface QuestionnaireService {

    List<GroupApp> getGroupAppOfEventQuestionnaire(Long idEvent);
    List<Question> getQuestionsOfGroup(Long idEvent, Long Group);
    Optional<Question> getQuestionById (Long idQuestion);

}
