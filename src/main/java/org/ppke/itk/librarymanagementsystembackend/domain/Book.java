package org.ppke.itk.librarymanagementsystembackend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@AllArgsConstructor()
@NoArgsConstructor
@Entity

//TODO
// Manuális konstruktor?
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;

    @Column(name = "genre")
//    @Enumerated(EnumType.STRING)
//    private Genre genre;
    private String genre;



    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private List<Item> items;

    @Column(name = "num_of_pages")
    private Integer numberOfPages;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "first_publication_year")
    private Integer firstPublicationYear;

    @Column(name = "cover")
    private String coverPath;

}
