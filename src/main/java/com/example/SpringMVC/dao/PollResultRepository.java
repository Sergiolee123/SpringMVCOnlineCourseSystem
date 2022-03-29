package com.example.SpringMVC.dao;

import com.example.SpringMVC.model.PollResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollResultRepository extends JpaRepository<PollResult, Long> {
}
