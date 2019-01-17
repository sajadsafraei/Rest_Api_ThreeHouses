package com.sajad.rest.com.sajad.rest.review;

import com.sajad.rest.com.sajad.rest.core.BaseEntity;
import com.sajad.rest.com.sajad.rest.course.Course;
import com.sajad.rest.com.sajad.rest.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Review extends BaseEntity {

    private String rating;
    private String description;

    @ManyToOne
    private Course course;

    @ManyToOne
    private User reviwer;


    protected Review() {
        super();
    }

    public Review(String rating, String description) {
        this.rating = rating;
        this.description = description;
    }


    public User getReviwer() {
        return reviwer;
    }

    public void setReviwer(User reviwer) {
        this.reviwer = reviwer;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
