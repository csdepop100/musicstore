package com.exxeta.musicstore.service;

import com.exxeta.musicstore.Exceptions.NeverDeleteFavouritesException;
import com.exxeta.musicstore.converter.RatingAttributeConverter;
import com.exxeta.musicstore.model.Album;
import com.exxeta.musicstore.model.Review;
import com.exxeta.musicstore.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final RatingAttributeConverter converter;

    public AlbumService(AlbumRepository albumRepository, RatingAttributeConverter converter) {
        this.albumRepository = albumRepository;
        this.converter = converter;
    }

    public List<Album> getAllAlbums() {
        var results = albumRepository.findAll();
        return new ArrayList<>(results);
    }

    public Optional<Album> findById(Long id) {
        return albumRepository.findById(id);
    }

    public void delete(Album album) {
        if (album.getReviews().size() >= 10 && calculateAvgRating(album) >= 4) {
            throw new NeverDeleteFavouritesException("Album with ID " + album.getId() + " is a favourite");
        }
        albumRepository.delete(album);
    }

    private double calculateAvgRating(Album album) {
        OptionalDouble average = album.getReviews().stream()
                .map(Review::getRating)
                .map(converter::convertToDatabaseColumn)
                .mapToInt(Integer::intValue)
                .average();
        if (average.isEmpty()) return 0.0f;
        return average.getAsDouble();
    }
}
