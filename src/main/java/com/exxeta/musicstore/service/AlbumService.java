package com.exxeta.musicstore.service;

import com.exxeta.musicstore.model.Album;
import com.exxeta.musicstore.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAllAlbums() {
        var results = albumRepository.findAll();
        return new ArrayList<>(results);
    }
}
