package org.ppke.itk.librarymanagementsystembackend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;

//    @Column(name = "is_rentable", nullable = false)
//    private Boolean isRentable;

    @Column(name = "condition")
//    @Enumerated(EnumType.STRING)
//    private Condition condition;
    private String condition;

}
