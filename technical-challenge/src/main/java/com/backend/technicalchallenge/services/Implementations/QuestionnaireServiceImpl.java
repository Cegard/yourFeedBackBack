package com.backend.technicalchallenge.services.Implementations;

import com.backend.technicalchallenge.model.evaluation.EvaluatedUser;
import com.backend.technicalchallenge.model.questionnaire.GroupApp;
import com.backend.technicalchallenge.model.questionnaire.Question;
import com.backend.technicalchallenge.model.questionnaire.Questionnaire;
import com.backend.technicalchallenge.persistance.GroupAppRepository;
import com.backend.technicalchallenge.persistance.QuestionRepository;
import com.backend.technicalchallenge.persistance.QuestionnaireQuestionRepository;
import com.backend.technicalchallenge.persistance.QuestionnaireRepository;
import com.backend.technicalchallenge.services.interfaces.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionnaireQuestionRepository questionnaireQuestionRepository;


    @Override
    public List<EvaluatedUser> getEvaluatedUserForAnEvent(Long idEvent) {
        return null;
    }

    @Override
    public List<Questionnaire> getEventQuestionnaire(Long idEvent) {
        return null;
    }

    @Override
    public List<Question> getQuestionsOnQuestionnaire(Long id) {
        return questionRepository.findByEvent(id);

    }

}