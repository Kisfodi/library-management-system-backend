package org.ppke.itk.librarymanagementsystembackend.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ppke.itk.librarymanagementsystembackend.domain.Rent;
import org.ppke.itk.librarymanagementsystembackend.domain.RentDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentDto {

    private Integer id;
    private ItemDto itemRented;
    private UserDto userOfRent;
    private RentDate rentDate;
    private Integer numberOfExtensions;


    public static RentDto fromRent(Rent rent) {
        return new RentDto(
                rent.getId(),
                ItemDto.fromItem(rent.getItemRented()),
                UserDto.fromUser(rent.getUserOfRent()),
                rent.getRentDate(),
                rent.getNumOfExtensions()
        );
    }

}
