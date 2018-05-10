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

    @Autowired
    private EventQuestionnaireRepository eventQuestionnaireRepository;

    @Autowired
    private QuestionnaireQuestionRepository questionnaireQuestionRepository;


    private  Map<GroupApp, List<Question> > orderedMapGroupQuestions(Long key) {
        Optional<EventQuestionnaire> eventUserQuestionnaire = eventQuestionnaireRepository.findAllUserQuestionnaireByIdEventAndStatus(key);
        Map<GroupApp, List<Question> > groups= new HashMap<>();
        List<QuestionnaireQuestion> questionnaireQuestion = questionnaireQuestionRepository.findAllBy(eventUserQuestionnaire.get().getQuestionnaire().getId());

        questionnaireQuestion.forEach(
                (QuestionnaireQuestion q) -> {

                    Optional<Question> question = questionRepository.findById(q.getQuestion().getId());

                    Optional<GroupApp> groupAppOfQuestion = groupAppRepository.findById(question.get().getGroupApp().getId());
                    if(groups.containsKey(groupAppOfQuestion.get())){
                        List<Question> questionsOfGroup = groups.get(groupAppOfQuestion);
                        questionsOfGroup.add(question.get());
                        groups.put(groupAppOfQuestion.get(), questionsOfGroup);
                    }else{
                        List<Question> questionsOfGroup = new ArrayList<>();
                        questionsOfGroup.add(question.get());
                        groups.put(groupAppOfQuestion.get(), questionsOfGroup );


                    }

                }
        );

        return groups;
    }

    @Override
    public Object[] getGroupAppOfEventQuestionnaire(Long idEvent) {

        Map<GroupApp, List<Question> > groups = orderedMapGroupQuestions(idEvent);

        return groups.keySet().toArray();
    }

    @Override
    public List<Question> getQuestionsOfGroup(Long idEvent, Long group) {
        Map<GroupApp, List<Question> > groups = orderedMapGroupQuestions(idEvent);
        Optional<GroupApp> groupApp = groupAppRepository.findById(group);
        return groups.get(groupApp.get());
    }
}
