package com.exxeta.musicstore;

import com.exxeta.musicstore.model.Album;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = Album.class)
public class MusicstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicstoreApplication.class, args);
    }

}
