package com.example.SpringMVC.service;

import com.example.SpringMVC.dao.PollRepository;
import com.example.SpringMVC.model.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PollService {

    private PollRepository pollRepository;

    @Autowired
    public void setPollRepository(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @Transactional(rollbackFor = Throwable.class)
    public void addPoll(Poll poll){
        poll.setDate(new Date());
        pollRepository.save(poll);
    }

    @Transactional
    public Optional<Poll> findPollById(Long id){
        return pollRepository.findById(id);
    }

    @Transactional
    public List<Poll> findAllPolls(){
        return pollRepository.findAll();
    }
}
