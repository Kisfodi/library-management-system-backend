package org.ppke.itk.librarymanagementsystembackend.unittests;


import org.junit.jupiter.api.Test;
import org.ppke.itk.librarymanagementsystembackend.controller.dto.AuthorDto;
import org.ppke.itk.librarymanagementsystembackend.domain.Author;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class AuthorDtoTest {

    @Test
    public void testAuthorDtoMapping() {

        Author author = new Author();
        author.setId(1);
        author.setName("John Doe");
        author.setDateOfBirth(LocalDate.of(1939, 9, 20));
        author.setDateOfDeath(LocalDate.of(2019, 7, 22));

        AuthorDto dtoUnderTest = AuthorDto.fromAuthor(author);

        assertEquals(dtoUnderTest.getName(), author.getName());
        assertEquals(dtoUnderTest.getDateOfBirth(), author.getDateOfBirth());
        assertEquals(dtoUnderTest.getDateOfDeath(), author.getDateOfDeath());

    }

    @Test
    public void testLivingAuthorDtoMapping() {
        Author author = new Author();
        author.setId(1);
        author.setName("John Doe");
        author.setDateOfBirth(LocalDate.of(1939, 9, 20));
//        author.setDateOfDeath(LocalDate.of(2019, 7, 22));

        AuthorDto dtoUnderTest = AuthorDto.fromAuthor(author);

        assertEquals(dtoUnderTest.getName(), author.getName());
        assertEquals(dtoUnderTest.getDateOfBirth(), author.getDateOfBirth());
        assertNull(dtoUnderTest.getDateOfDeath());
//        assertEquals(dtoUnderTest.getDateOfDeath(), author.getDateOfDeath());

    }



}
