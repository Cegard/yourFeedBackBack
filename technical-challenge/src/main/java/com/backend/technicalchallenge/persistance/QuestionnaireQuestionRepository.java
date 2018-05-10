package com.backend.technicalchallenge.persistance;


import com.backend.technicalchallenge.model.questionnaire.Questionnaire;
import com.backend.technicalchallenge.model.questionnaire.QuestionnaireQuestion;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface QuestionnaireQuestionRepository extends PagingAndSortingRepository<QuestionnaireQuestion, Long> {

    @Query(value = "SELECT qq.* FROM questionnaire_question qq WHERE qq.questionnaire_id = :idQuestionnaire ", nativeQuery = true)
    List<QuestionnaireQuestion> findAllBy(@Param("idQuestionnaire") Long idQuestionnaire);

}
