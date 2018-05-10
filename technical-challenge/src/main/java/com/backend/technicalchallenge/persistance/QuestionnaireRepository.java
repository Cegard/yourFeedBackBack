package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.event.Event;
import com.backend.technicalchallenge.model.questionnaire.GroupApp;
import com.backend.technicalchallenge.model.questionnaire.Questionnaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface QuestionnaireRepository extends PagingAndSortingRepository<Questionnaire, Long> {


    List<Questionnaire> findByEventQuestionnaires(Event event);


}
