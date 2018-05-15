package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.questionnaire.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.Table;
import java.util.List;
import java.util.Map;

public interface AnswerRepository extends PagingAndSortingRepository<Answer, Long> {

    List<Answer> findAllByStatus(Status status);

    @Query(value = "SELECT gapp.name as name_group, (sum(ans.score)/count(gapp.id)) as score \n" +
            "\tFROM answer ans join question q on q.id = ans.question_id join group_app gapp on q.group_app_id = gapp.id where ans.evaluation_id = :idEvaluation GROUP BY 1 \n", nativeQuery = true)
    Map<String, Double> getScore(@Param("idEvaluation") Long idEvaluation);

}
