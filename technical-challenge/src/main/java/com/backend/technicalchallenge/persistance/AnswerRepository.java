package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.DTO.GroupAppDTO;
import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.questionnaire.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;



public interface AnswerRepository extends PagingAndSortingRepository<Answer, Long> {

    List<Answer> findAllByStatus(Status status);

    @Query(value = "SELECT ans.id, gapp.name , (sum(ans.score)/count(gapp.id))  \n" +
            "\tFROM answer ans join question q on q.id = ans.question_id join group_app gapp on q.group_app_id = gapp.id where ans.evaluation_id = :idEvaluation GROUP BY 1,2 \n", nativeQuery = true)
    List<Object> getScore(@Param("idEvaluation") Long idEvaluation);


}
