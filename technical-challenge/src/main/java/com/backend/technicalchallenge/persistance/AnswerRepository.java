package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.questionnaire.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;



public interface AnswerRepository extends PagingAndSortingRepository<Answer, Long> {

    List<Answer> findAllByStatus(Status status);


    @Query(value = "SELECT gapp.id, gapp.name, gapp.description , avg(ans.score)  \n" +
            "\tFROM answer ans " +
            "join question q on ans.question_id = q.id " +
            "join group_app gapp on q.group_app_id = gapp.id " +
            "join evaluation ev on ev.id = ans.evaluation_id " +
            "join evaluated_user evus on ev.evaluated_user_id = evus.id " +
            "where ev.event_id = :idEvent and evus.user_app_id = :idUser GROUP BY 1,2,3 \n", nativeQuery = true)
    List<Object> getScore(@Param("idEvent") Long idEvent,@Param("idUser") Long idUser);

    @Query(value = "SELECT gapp.name, q.question, avg(ans.score) from answer ans " +
            "join question q on ans.question_id = q.id " +
            "join group_app gapp on q.group_app_id = gapp.id " +
            "join evaluation ev on ev.id = ans.evaluation_id " +
            "join evaluated_user evus on ev.evaluated_user_id = evus.id " +
            " where ev.event_id = :idEvent and evus.user_app_id = :idUser and gapp.id = :idGroup group by q.id, gapp.id" , nativeQuery = true)
    List<Object> getAverage(@Param("idEvent") Long idEvent,@Param("idUser") Long idUser,@Param("idGroup") Long idGroup);


}
