package org.ppke.itk.librarymanagementsystembackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ppke.itk.librarymanagementsystembackend.domain.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Integer id;
    private String title;
    private AuthorDto author;
    private List<Item> items;
    private String genre;
    private Integer numberOfPages;
    private Integer publicationYear;
    private String coverPath;

    public static BookDto fromBook(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                AuthorDto.fromAuthor(book.getAuthor()),
                book.getItems(),
                book.getGenre().getGenreName(),
                book.getNumberOfPages(),
                book.getPublicationYear(),
                book.getCoverPath()
        );
    }
}
