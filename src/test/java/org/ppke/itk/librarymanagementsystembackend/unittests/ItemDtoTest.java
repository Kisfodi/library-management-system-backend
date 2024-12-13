package org.ppke.itk.librarymanagementsystembackend.unittests;

import org.junit.jupiter.api.Test;
import org.ppke.itk.librarymanagementsystembackend.controller.dto.ItemDto;
import org.ppke.itk.librarymanagementsystembackend.domain.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ItemDtoTest {

    @Test
    public void itemDtoTest() {

        Item item = new Item();
        item.setId(1);

        Book book = new Book();
        book.setId(1);
        book.setTitle("Title");

        Author author = new Author();
        author.setId(1);
        author.setName("John Doe");
        author.setDateOfBirth(LocalDate.of(1976, 12, 3));
        author.setDateOfDeath(LocalDate.of(2023, 12, 12));

        book.setAuthor(author);

        book.setGenre(Genre.of("Fantasy"));
        book.setNumberOfPages(168);
        book.setPublicationYear(2003);

        item.setBook(book);
        item.setIsAvailable(true);
        item.setCondition(Condition.MINT);

        ItemDto dtoUnderTest = ItemDto.fromItem(item);

        assertEquals(dtoUnderTest.getId(), item.getId());
        assertEquals(dtoUnderTest.getBookTitle(), item.getBook().getTitle());
        assertEquals(dtoUnderTest.getIsAvailable(), item.getIsAvailable());
        assertEquals(dtoUnderTest.getCondition(), item.getCondition().getCondition());

    }

}
