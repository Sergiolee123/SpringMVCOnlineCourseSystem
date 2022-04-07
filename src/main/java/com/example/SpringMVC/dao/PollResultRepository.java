package com.example.SpringMVC.dao;

import com.example.SpringMVC.model.PollResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PollResultRepository extends JpaRepository<PollResult, Long> {
    @Query(value = "SELECT * FROM PollResult p WHERE p.user_id = :userId and p.poll_id = :pollId",
            nativeQuery = true)
    public PollResult existByUser(@Param("userId") String userId, @Param("pollId") Long pollId);
}
