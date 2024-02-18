package com.nnm.firstjob.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nnm.firstjob.company.company;
import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private  String discription;
    private double Rating;
    @JsonIgnore
    @ManyToOne
    private company company;
    public Review() {
    }

    public com.nnm.firstjob.company.company getCompany() {
        return company;
    }

    public void setCompany(com.nnm.firstjob.company.company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }
}
