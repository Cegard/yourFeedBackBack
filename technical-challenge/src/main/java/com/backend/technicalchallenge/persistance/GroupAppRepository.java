package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.questionnaire.GroupApp;
import com.backend.technicalchallenge.model.questionnaire.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GroupAppRepository extends PagingAndSortingRepository<GroupApp, Long> {


    Optional<GroupApp> findById(Long id);
    @Query(value = "SELECT g.* FROM group_app g\n" +
            "join question q on q.group_app_id = g.id\n"+
            "join questionnaire_question qq on q.id = qq.question_id\n" +
            "join event_questionnaire eq on qq.questionnaire_id = eq.questionnaire_id \n" +
            "where eq.event_id = :idEvent group by g.id  ",nativeQuery = true)
    List<GroupApp> findByEvent(@Param("idEvent") Long idEVent);


}
