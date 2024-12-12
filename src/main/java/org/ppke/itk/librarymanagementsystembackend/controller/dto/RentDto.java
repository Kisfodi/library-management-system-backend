package org.ppke.itk.librarymanagementsystembackend.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ppke.itk.librarymanagementsystembackend.domain.Condition;
import org.ppke.itk.librarymanagementsystembackend.domain.Rent;
import org.ppke.itk.librarymanagementsystembackend.domain.RentDate;
import org.ppke.itk.librarymanagementsystembackend.domain.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentDto {

    private Integer id;

    private Integer itemRentedId;
    private String bookTitle;
    private String bookAuthorName;

//    private User user;

    private String userName;
    private RentDate rentDate;

//    private LocalDateTime startDate;
//    private LocalDateTime returnDate;
    private Condition condition;
//    private boolean itemRented;


    public static RentDto fromRent(Rent rent) {
        return new RentDto(
                rent.getId(),
                rent.getItemRented().getId(),
                rent.getItemRented().getBook().getTitle(),
                rent.getItemRented().getBook().getAuthor().getName(),
                rent.getUserOfRent().getUsername(),
                rent.getRentDate(),
                rent.getItemRented().getCondition()
//                rent.getItemRented().getIsAvailable()
        );
    }

}
