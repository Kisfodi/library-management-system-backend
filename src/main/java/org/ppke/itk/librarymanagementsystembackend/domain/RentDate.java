package org.ppke.itk.librarymanagementsystembackend.domain;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rent_date")
public class RentDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "deadline")
    private LocalDateTime deadline;

}
