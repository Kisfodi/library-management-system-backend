package org.ppke.itk.librarymanagementsystembackend.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.ppke.itk.librarymanagementsystembackend.domain.Genre;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class GenreConverter implements AttributeConverter<Genre, String> {

    @Override
    public String convertToDatabaseColumn(Genre genre) {


        if (genre == null) {
            return null;
        }

        return genre.getGenreName();
    }

    @Override
    public Genre convertToEntityAttribute(String s) {

        if (s == null) {
            return null;
        }

        return Genre.of(s);


    }
}
