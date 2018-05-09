package com.backend.technicalchallenge.persistance;

import com.backend.technicalchallenge.model.user.UserApp;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<UserApp, Long> {

        List<UserApp> findAll();
        UserApp findByEmailAndPassword(String email, String password);
        Optional<UserApp> findById(Long id);


}
