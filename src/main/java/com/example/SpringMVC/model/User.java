package com.example.SpringMVC.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "USER_INFO")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userID;
    @Column(name="username", length=50, nullable=false)
    private String username;
    @Column(name="password", length=50, nullable=false)
    private String password;
    @Column(name="role", length=50, nullable=false)
    private String role;
    @Column(name="fullName", length=50, nullable=false)
    private String fullName;
    @Column(name="phone_number", length=50, nullable=false)
    private String phoneNumber;
    @Column(name="address", length=50, nullable=false)
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Comment> comments;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<PollResult> pollResults;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<PollResult> getPollResults() {
        return pollResults;
    }

    public void setPollResults(List<PollResult> pollResults) {
        this.pollResults = pollResults;
    }
}
