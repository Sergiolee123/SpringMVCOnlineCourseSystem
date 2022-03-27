package com.example.SpringMVC.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Poll implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pollID;
    @Column(name="option_a", length=50)
    private String option1;
    @Column(name="option_b", length=50)
    private String option2;
    @Column(name="option_c", length=50)
    private String option3;
    @Column(name="option_d", length=50)
    private String option4;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "poll")
    private List<PollResult> pollResults;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getPollID() {
        return pollID;
    }

    public void setPollID(Long pollID) {
        this.pollID = pollID;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public List<PollResult> getPollResults() {
        return pollResults;
    }

    public void setPollResults(List<PollResult> pollResults) {
        this.pollResults = pollResults;
    }
}
