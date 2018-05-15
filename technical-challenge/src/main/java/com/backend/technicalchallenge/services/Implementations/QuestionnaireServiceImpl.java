package com.backend.technicalchallenge.services.Implementations;


import com.backend.technicalchallenge.model.event.EventQuestionnaire;
import com.backend.technicalchallenge.model.questionnaire.GroupApp;
import com.backend.technicalchallenge.model.questionnaire.Question;
import com.backend.technicalchallenge.model.questionnaire.QuestionnaireQuestion;
import com.backend.technicalchallenge.persistance.*;
import com.backend.technicalchallenge.services.interfaces.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private GroupAppRepository groupAppRepository;



    @Override
    public List<GroupApp> getGroupAppOfEventQuestionnaire(Long idEvent) {

       return groupAppRepository.findByEvent(idEvent);
    }

    @Override
    public List<Question> getQuestionsOfGroup(Long idEvent, Long group) {

        return questionRepository.findByEventAndGroupApp(idEvent,group);
    }

    @Override
    public Optional<Question> getQuestionById(Long idQuestion) {
        return questionRepository.findById(idQuestion);
    }
}
