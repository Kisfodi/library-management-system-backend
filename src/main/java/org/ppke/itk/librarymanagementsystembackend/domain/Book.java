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
    @Column(name = "id")
    private Integer id;

    private String title;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "genre_id")
    @Column
    private Genre genre;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private List<Item> items;

    @Column(name = "cover")
    private String coverPath;

}
