package org.ppke.itk.librarymanagementsystembackend.repository;

import org.ppke.itk.librarymanagementsystembackend.domain.Rent;

public interface CustomRentRepository {

    Rent saveRent(Integer itemId, String username);

    void deleteRent(Integer itemId, String username);

    void returnRent(Integer itemId, String username);

    void extendDeadline(Integer itemId, String username);

//    public Rent updateRent

//    void deleteRent(Integer itemId, String username);

//    void updateRent(Integer itemId, String username, Rent rent);

}
