package com.example.SpringMVC.service;

import com.example.SpringMVC.dao.PollRepository;
import com.example.SpringMVC.dao.PollResultRepository;
import com.example.SpringMVC.dao.UserRepository;
import com.example.SpringMVC.exception.PollNotFoundException;
import com.example.SpringMVC.exception.UserNotFindException;
import com.example.SpringMVC.model.PollResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Date;

@Service
public class PollResultService {

    private PollResultRepository pollResultRepository;
    private PollRepository pollRepository;
    private UserRepository userRepository;

    @Autowired
    public void setPollResultRepository(PollResultRepository pollResultRepository) {
        this.pollResultRepository = pollResultRepository;
    }

    @Autowired
    public void setPollRepository(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(rollbackFor = Throwable.class)
    public void addPollResult(Long pollId, String option, Principal principal)
            throws PollNotFoundException, UserNotFindException {

        PollResult pollResult = new PollResult();
        pollResult.setPoll(pollRepository.findById(pollId).orElseThrow(PollNotFoundException::new));
        pollResult.setUser(userRepository.findById(principal.getName()).orElseThrow(UserNotFindException::new));
        pollResult.setOption(option);
        pollResult.setDate(new Date());
        pollResultRepository.save(pollResult);
    }
}
