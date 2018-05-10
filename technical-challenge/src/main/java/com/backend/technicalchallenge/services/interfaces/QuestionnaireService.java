package com.backend.technicalchallenge.services.interfaces;


import com.backend.technicalchallenge.model.questionnaire.Question;

import java.util.List;


public interface QuestionnaireService {

    Object[] getGroupAppOfEventQuestionnaire(Long idEvent);
    List<Question> getQuestionsOfGroup(Long idEvent, Long Group);

}
