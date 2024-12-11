package org.ppke.itk.librarymanagementsystembackend.domain;

public enum Genre {
    SCIFI("Sci-Fi"),
    FANTASY("Fantasy"),
    THRILLER("Thriller"),
    CRIME_NOVEL("Crime"),
    AUTOBIOGRAPHY("Autobiography"),
    ADVENTURE("Adventure"),
//    Adventure("Adventure"),

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

}
