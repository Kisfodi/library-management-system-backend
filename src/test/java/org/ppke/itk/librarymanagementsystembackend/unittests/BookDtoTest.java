package org.ppke.itk.librarymanagementsystembackend.unittests;

import org.junit.jupiter.api.Test;
import org.ppke.itk.librarymanagementsystembackend.controller.dto.BookDto;
import org.ppke.itk.librarymanagementsystembackend.domain.Author;
import org.ppke.itk.librarymanagementsystembackend.domain.Book;
import org.ppke.itk.librarymanagementsystembackend.domain.Genre;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BookDtoTest {

    @Test
    public void testBookDto() {

        Book book = new Book();
        book.setId(1);
        book.setTitle("Title");

        Author author = new Author();
        author.setId(1);
        author.setName("John Doe");
        author.setDateOfBirth(LocalDate.of(1976, 12, 3));
        author.setDateOfDeath(LocalDate.of(2023, 12, 12));

        book.setAuthor(author);

        book.setGenre(Genre.FANTASY);
        book.setNumberOfPages(168);
        book.setPublicationYear(2003);

        BookDto dtoUnderTest = BookDto.fromBook(book);

        assertEquals(dtoUnderTest.getId(), book.getId());
        assertEquals(dtoUnderTest.getTitle(), book.getTitle());
        assertEquals(dtoUnderTest.getAuthor().getName(), book.getAuthor().getName());
        assertEquals(dtoUnderTest.getGenre(), book.getGenre().getGenreName());
//        assertEquals(1, Arrays.stream(Genre.values()).filter(genre -> genre.equals(dtoUnderTest.getGenre())).count());
        assertEquals(dtoUnderTest.getNumberOfPages(), book.getNumberOfPages());
        assertEquals(dtoUnderTest.getPublicationYear(), book.getPublicationYear());

//        assertEquals(Genre.ADVENTURE, Genre.fromString("Adventure"));

    }

}
