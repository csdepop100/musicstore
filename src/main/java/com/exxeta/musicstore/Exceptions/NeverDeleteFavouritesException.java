package com.exxeta.musicstore.Exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class NeverDeleteFavouritesException extends DataIntegrityViolationException {
    public NeverDeleteFavouritesException(String msg) {
        super(msg);
    }
}
