package com.sajad.rest.com.sajad.rest.course;

import com.sajad.rest.com.sajad.rest.review.Review;
import com.sajad.rest.com.sajad.rest.core.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Course extends BaseEntity {
    @NotNull
    @Size(min = 2)
    private String title;
    private String url;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Review> reviews;

    protected Course() {
        super();
        reviews = new ArrayList<>();
    }

    public Course(String title, String url) {
        this();
        this.title = title;
        this.url = url;
    }

    public void addReview(Review r) {
        r.setCourse(this);
        this.reviews.add(r);

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


}
