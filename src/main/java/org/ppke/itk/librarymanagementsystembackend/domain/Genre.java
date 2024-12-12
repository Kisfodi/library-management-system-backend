package org.ppke.itk.librarymanagementsystembackend.domain;


import jakarta.annotation.Priority;

import java.util.Objects;
import java.util.stream.Stream;

public enum Genre {
    SCIFI("Sci-Fi"),
    FANTASY("Fantasy"),
    THRILLER("Thriller"),
    CRIME_NOVEL("Crime"),
    AUTOBIOGRAPHY("Autobiography"),
//    Adventure("Adventure"),
    ADVENTURE("Adventure"),

    DETECTIVE_FICTION("Detective Fiction");

    private final String genreName;

    public String getGenreName() {
        return genreName;
    }

    Genre(String genreName) {
        this.genreName = genreName;
    }

    public static Genre fromString(String genreName) {
        for (Genre genre : Genre.values()) {
            if (genre.getGenreName().equalsIgnoreCase(genreName)) {
                return genre;
            }
        }
        return null;
    }

    public static Genre of(String genreName) {
        return Stream.of(Genre.values())
                .filter(genre ->
                        genre.getGenreName().equals(genreName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
