package org.ppke.itk.librarymanagementsystembackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User userOfRent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private Item itemRented;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "rent_date_id")
    private RentDate rentDate;

/*    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "deadline")
    private LocalDateTime deadline;
    */

    @Column(name = "num_of_extensions")
    private Integer numOfExtensions;



}
