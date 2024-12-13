package org.ppke.itk.librarymanagementsystembackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ppke.itk.librarymanagementsystembackend.domain.Author;
import org.ppke.itk.librarymanagementsystembackend.domain.Book;
import org.ppke.itk.librarymanagementsystembackend.domain.Genre;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Integer id;
    private String title;
    private AuthorDto author;
    private String genre;
    private Integer numberOfPages;
    private Integer publicationYear;

    public static BookDto fromBook(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                AuthorDto.fromAuthor(book.getAuthor()),
                book.getGenre().getGenreName(),
                book.getNumberOfPages(),
                book.getPublicationYear()
        );
    }

}
