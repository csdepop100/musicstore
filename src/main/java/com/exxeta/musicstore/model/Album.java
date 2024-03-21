package com.exxeta.musicstore.model;

import java.time.LocalDateTime;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private LocalDateTime release;
    private List<Review> reviews;
}
