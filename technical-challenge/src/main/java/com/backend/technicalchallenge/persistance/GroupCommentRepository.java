package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.evaluation.GroupComment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GroupCommentRepository  extends PagingAndSortingRepository<GroupComment, Long> {

    Optional<GroupComment> findById(Long id);
    List<GroupComment> findAll();
    @Query(value = "SELECT gcom.* FROM group_comment gcom join evaluation ev on gcom.evaluation_id = ev.id where ev.evaluated_user_id = :idEvalutedUser and gcom.group_app_id = :idGroupApp", nativeQuery = true)
    List<GroupComment> findByGroupAppIdAndAndEvaluatedUserId(@Param("idGroupApp")Long idGroupApp, @Param("idEvalutedUser") Long idEvalutedUser);


}
