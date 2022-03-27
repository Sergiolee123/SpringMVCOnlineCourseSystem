package com.example.SpringMVC.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Lecture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectureID;
    @Column(name="lecture_title", length=50, nullable=false)
    private String lectureTitle;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "lecture")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Material> materials;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "lecture")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Comment> comments;


    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materialList) {
        this.materials = materialList;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getLectureID() {
        return lectureID;
    }

    public void setLectureID(Long lectureID) {
        this.lectureID = lectureID;
    }

    public String getLectureTitle() {
        return lectureTitle;
    }

    public void setLectureTitle(String lectureTitle) {
        this.lectureTitle = lectureTitle;
    }
}
