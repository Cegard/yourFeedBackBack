package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.questionnaire.GroupApp;
import com.backend.technicalchallenge.model.questionnaire.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {

    Question findByGroupApp(GroupApp groupApp);
    @Query(value = "SELECT q.* FROM question q\n" +
            "join questionnaire_question qq on q.id = qq.question_id\n" +
            "join event_questionnaire eq on qq.questionnaire_id = eq.questionnaire_id \n" +
            "where eq.event_id = :id and eq.type='USER' order by q.group_app_id ",nativeQuery = true)
    List<Question> findByEvent(@Param("id") Long id);



}
