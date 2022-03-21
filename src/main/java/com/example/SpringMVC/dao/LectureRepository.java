package com.example.SpringMVC.dao;



import com.example.SpringMVC.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {

}
