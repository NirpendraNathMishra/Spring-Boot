package com.nnm.firstjob.job;

import com.nnm.firstjob.company.company;
import jakarta.persistence.*;

@Entity

public class job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String discraption;
    private String minsalary;
    private String maxsalary;
    private String location;
    @ManyToOne
    private company company;

    public job() {
    }

    public job(long id, String title, String discraption, String minsalary, String maxsalary, String location) {
        this.id = id;
        this.title = title;
        this.discraption = discraption;
        this.minsalary = minsalary;
        this.maxsalary = maxsalary;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscraption() {
        return discraption;
    }

    public void setDiscraption(String discraption) {
        this.discraption = discraption;
    }

    public String getMinsalary() {
        return minsalary;
    }

    public void setMinsalary(String minsalary) {
        this.minsalary = minsalary;
    }

    public String getMaxsalary() {
        return maxsalary;
    }

    public void setMaxsalary(String maxsalary) {
        this.maxsalary = maxsalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
