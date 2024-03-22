package com.exxeta.musicstore.model;

import jakarta.persistence.Id;

public class Review {
    @Id
    private Long pkId;
    private String user;
    private Rating rating;
    private String comment;
}
