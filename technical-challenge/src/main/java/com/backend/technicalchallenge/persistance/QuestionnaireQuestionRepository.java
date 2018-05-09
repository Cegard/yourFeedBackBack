package com.backend.technicalchallenge.persistance;


import com.backend.technicalchallenge.model.questionnaire.Questionnaire;
import com.backend.technicalchallenge.model.questionnaire.QuestionnaireQuestion;

import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

public interface QuestionnaireQuestionRepository extends PagingAndSortingRepository<QuestionnaireQuestion, Long> {

//    List<QuestionnaireQuestion> findAllBy(Questionnaire questionnaire);

}
