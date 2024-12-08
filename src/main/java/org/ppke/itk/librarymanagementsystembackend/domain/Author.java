package org.ppke.itk.librarymanagementsystembackend.domain;



//TODO
// Do make the domain for all classes

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private Date birthDate;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Book> books;



}
