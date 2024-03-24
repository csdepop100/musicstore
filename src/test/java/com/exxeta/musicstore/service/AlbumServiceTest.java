package com.exxeta.musicstore.service;

import com.exxeta.musicstore.Exceptions.NeverDeleteFavouritesException;
import com.exxeta.musicstore.model.Album;
import com.exxeta.musicstore.model.Rating;
import com.exxeta.musicstore.model.Review;
import com.exxeta.musicstore.repository.AlbumRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AlbumServiceTest {

    @MockBean
    AlbumRepository albumRepository;

    @Autowired
    AlbumService albumService;

    @Test
    void preventDeletion() {
        var reviews = new HashSet<Review>();
        for (long i = 1; i <= 10; i++) {
            reviews.add(new Review(i, "TestUser", Rating.FIVE, null));
        }
        var album = new Album(1L,
                "TestAlbum",
                "TestArtist",
                LocalDateTime.of(1995,
                        8,
                        29,
                        0,
                        0),
                reviews);
        Mockito.when(albumRepository.findById(1L)).thenReturn(Optional.of(album));

        Exception e = assertThrows(NeverDeleteFavouritesException.class,
                () -> albumService.delete(album));

        var expectedMessage = "Album with ID 1 is a favourite";
        var actualMessage = e.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
