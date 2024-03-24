package com.exxeta.musicstore.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String artist;
    @Column(name = "release_date")
    private LocalDateTime releaseDate;
    @OneToMany(targetEntity = Review.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "album")
    private Set<Review> reviews;

    public Album() {
    }

    public Album(Long pkId,
                 String name,
                 String artist,
                 LocalDateTime releaseDate,
                 Set<Review> reviews) {
        this.id = pkId;
        this.name = name;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long pkId) {
        this.id = pkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
