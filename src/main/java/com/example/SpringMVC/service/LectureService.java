package com.example.SpringMVC.service;

import com.example.SpringMVC.dao.LectureRepository;
import com.example.SpringMVC.model.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LectureService {
    private LectureRepository lectureRepository;

    @Autowired
    public void setLectureDao(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Transactional(rollbackFor = Throwable.class)
    public List<Lecture> findAllLectures(){
        return lectureRepository.findAll();
    }

    @Transactional(rollbackFor = Throwable.class)
    public Lecture findLectureById(Long id){
        return lectureRepository.findById(id).orElse(null);
    }

    @Transactional(rollbackFor = Throwable.class)
    public void saveLecture(Lecture lecture){
        lectureRepository.save(lecture);
    }

}
