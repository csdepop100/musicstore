package com.exxeta.musicstore.model;

import com.exxeta.musicstore.converter.RatingAttributeConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "album_reviews")
public class Review {
    @Id
    private Long pkId;
    private String user;
    @Convert(converter = RatingAttributeConverter.class)
    private Rating rating;
    private String comment;

    public Review() {
    }

    public Review(Long pkId,
                  String user,
                  Rating rating,
                  String comment) {
        this.pkId = pkId;
        this.user = user;
        this.rating = rating;
        this.comment = comment;
    }

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
