package org.ppke.itk.librarymanagementsystembackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ppke.itk.librarymanagementsystembackend.domain.Author;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private Integer id;
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;

    public static AuthorDto fromAuthor(Author author) {
        return new AuthorDto(
                author.getId(),
                author.getName(),
                author.getDateOfBirth(),
                author.getDateOfDeath()
        );
    }

}
