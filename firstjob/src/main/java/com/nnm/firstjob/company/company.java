package com.nnm.firstjob.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nnm.firstjob.job.job;

import com.nnm.firstjob.review.Review;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String discription;
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<job>jobs;


    @OneToMany(mappedBy = "company")

    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public company(Long id, String name, String discription, List<job> jobs) {
        this.id = id;
        this.name = name;
        this.discription = discription;
        this.jobs = jobs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public List<job> getJobs() {
        return jobs;
    }

    public void setJobs(List<job> jobs) {
        this.jobs = jobs;
    }

    public company() {
    }
}
