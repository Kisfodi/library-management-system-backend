package org.ppke.itk.librarymanagementsystembackend.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ppke.itk.librarymanagementsystembackend.domain.Condition;
import org.ppke.itk.librarymanagementsystembackend.domain.Rent;
import org.ppke.itk.librarymanagementsystembackend.domain.RentDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentDto {

    private Integer id;

    private Integer itemRentedId;
    private String bookTitle;
    private String bookAuthorName;
    private String userName;
    private RentDate rentDate;
    private Integer numberOfExtensions;
    private Condition condition;
//    private boolean isAvailable;


    public static RentDto fromRent(Rent rent) {
        return new RentDto(
                rent.getId(),
                rent.getItemRented().getId(),
                rent.getItemRented().getBook().getTitle(),
                rent.getItemRented().getBook().getAuthor().getName(),
                rent.getUserOfRent().getUsername(),
                rent.getRentDate(),
                rent.getNumOfExtensions(),
                rent.getItemRented().getCondition()
//                rent.getItemRented().getIsAvailable()
        );
    }

}
