package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.evaluation.GroupComment;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface GroupCommentRepository  extends PagingAndSortingRepository<GroupComment, Long> {

    Optional<GroupComment> findById(Long id);
    List<GroupComment> findAll();
}