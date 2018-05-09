package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.questionnaire.GroupApp;
import com.backend.technicalchallenge.model.questionnaire.Questionnaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupAppRepository extends PagingAndSortingRepository<GroupApp, Long> {

    //@Query(value="SELECT public.question.* from public.question, public.questionnaire_question where public.question.id = public.questionnaire_question.question_id and public.questionnaire_question.questionnaire_id= 1", nativeQuery = true)
//    @Query(value="SELECT * from group_app", nativeQuery = true)
    @Query(value = "select * from group_app g inner join question q on g.id=q.group_app_id ",nativeQuery = true)
    List<GroupApp> findGroupApp();
    //List<Long> findGroupByEventQuestionnaires(@Param("idQuestionnaire") Long idQuestionnaire);

}
