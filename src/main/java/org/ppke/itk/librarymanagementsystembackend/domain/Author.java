package org.ppke.itk.librarymanagementsystembackend.domain;

//TODO
// Do make the domain for all classes

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Author.deleteByName", query = "delete from Author a where a.name = :name")
})
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    @Column(name = "born_in", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "died_in", nullable = true)
    private LocalDate dateOfDeath;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Book> books;

    @Column
    private String placeOfBirth;

    @Column
    private String placeOfDeath;

    @Column(name = "portrait")
    private String portraitPath;



}
