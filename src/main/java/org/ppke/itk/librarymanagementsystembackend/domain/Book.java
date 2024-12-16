package org.ppke.itk.librarymanagementsystembackend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;

    @JsonManagedReference
    @OneToMany(mappedBy = "book")
    private List<Item> items;

    @Column(name = "genre")
//    @Convert(converter = GenreConverter.class)
    private Genre genre;

    @Column(name = "num_of_pages")
    private Integer numberOfPages;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "first_publication_year")
    private Integer firstPublicationYear;

    @Column(name = "cover")
    private String coverPath;

/*    public Book(
                Integer id,
                String title,
                Author author,
                String genre,
                List<Item> items,
                Integer numberOfPages,
                Integer publicationYear,
                Integer firstPublicationYear,
                String coverPath) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.items = items;
        this.genre = Genre.fromString(genre);
        this.numberOfPages = numberOfPages;
        this.publicationYear = publicationYear;
        this.firstPublicationYear = firstPublicationYear;
        this.coverPath = coverPath;
    }*/

/*    public Book(
            Integer id,
            String title,
            Author author,
            Genre genre,
            List<Item> items,
            Integer numberOfPages,
            Integer publicationYear,
            Integer firstPublicationYear,
            String coverPath) {

        this(id, title, author, genre.getGenreName(), items, numberOfPages, publicationYear, firstPublicationYear, coverPath);

    }*/

}
