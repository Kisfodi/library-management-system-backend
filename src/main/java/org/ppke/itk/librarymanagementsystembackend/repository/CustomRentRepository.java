package org.ppke.itk.librarymanagementsystembackend.repository;

import org.ppke.itk.librarymanagementsystembackend.domain.Rent;

public interface CustomRentRepository {

    Rent createRent(Integer itemId, String username);

    void deleteRent(Integer rentId);

//    void deleteRent(Integer itemId, String username);

    void updateRent(Integer itemId, String username, Rent rent);

}
