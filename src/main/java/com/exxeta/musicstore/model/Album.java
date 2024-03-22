package com.exxeta.musicstore.model;

import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;

public class Album {
    @Id
    private Long pkId;
    private String name;
    private String artist;
    private LocalDateTime releaseDate;
    private List<Review> reviews;
}
