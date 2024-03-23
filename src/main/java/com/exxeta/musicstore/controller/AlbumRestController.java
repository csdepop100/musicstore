package com.exxeta.musicstore.controller;

import com.exxeta.musicstore.Exceptions.NeverDeleteFavouritesException;
import com.exxeta.musicstore.model.Album;
import com.exxeta.musicstore.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/album")
@Controller
public class AlbumRestController {

    private final AlbumService albumService;

    public AlbumRestController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Album>> getAllAlbums() {
        var albums = albumService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlbumById(@PathVariable("id") Long id) {
        var existingAlbum = albumService.findById(id);
        if (existingAlbum.isPresent()) {
            albumService.delete(existingAlbum.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "This is one of our favourites")
    @ExceptionHandler(NeverDeleteFavouritesException.class)
    public void deletionConflict() {
        // nothing to do
    }
}
