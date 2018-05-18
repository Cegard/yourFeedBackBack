package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.evaluation.GroupComment;
import com.backend.technicalchallenge.model.questionnaire.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {

    @Query(value = "SELECT q.* FROM question q\n" +
            "join questionnaire_question qq on q.id = qq.question_id\n" +
            "join event_questionnaire eq on qq.questionnaire_id = eq.questionnaire_id \n" +
            "where eq.event_id = :idEvent and q.group_app_id = :idGroup order by q.group_app_id ", nativeQuery = true)
    List<Question> findByEventAndGroupApp(@Param("idEvent") Long idEVent, @Param("idGroup") Long idGroup);

    Optional<Question> findById(Long id);

}
