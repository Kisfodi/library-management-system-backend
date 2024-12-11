package org.ppke.itk.librarymanagementsystembackend.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.ppke.itk.librarymanagementsystembackend.domain.Item;
import org.ppke.itk.librarymanagementsystembackend.domain.Rent;
import org.ppke.itk.librarymanagementsystembackend.domain.RentDate;
import org.ppke.itk.librarymanagementsystembackend.domain.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.*;

@Repository
@RequiredArgsConstructor
public class CustomRentRepositoryImpl implements CustomRentRepository {

    @PersistenceContext
    EntityManager entityManager;

    private final RentRepository rentRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Rent saveRent(Integer itemId, String username) {

        Rent rent;
        Optional<Item> item = itemRepository.findById(itemId);
        if (item.isEmpty()) {
            throw new NoSuchElementException("No item found with id " + itemId);
        }

        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new NoSuchElementException("No user found with name " + username);
        }

        Optional<Rent> existingRent = rentRepository.findNotReturnedRent(username, itemId);
        if (existingRent.isPresent()) {
            throw new IllegalStateException("Item is already rented!");
            /*
            rent = existingRent.get();
            rent.setReturnDate(LocalDateTime.now());

            itemRepository.updateAvailability(true, item.get().getId());
            itemRepository.saveAndFlush(item.get());
            rentRepository.saveAndFlush(rent);
            */


        } else {
            rent = new Rent();
            rent.setUserOfRent(user.get());
            rent.setItemRented(item.get());

            RentDate rentDate = new RentDate();
            rentDate.setStartDate(LocalDateTime.now());
            rentDate.setDeadline(rentDate.getStartDate().plusWeeks(2));

            rent.setNumOfExtensions(0);

            itemRepository.updateAvailability(false, item.get().getId());
            rent.setRentDate(entityManager.merge(rentDate));

//            itemRepository.saveAndFlush(item.get());
            //            item.get().setIsAvailable(entityManager.merge(false));

            entityManager.persist(rent);

        }
        /*

         */

        return rent;
    }

    @Override
    @Transactional
    public void deleteRent(Integer itemId, String username, Integer rentDateId) {
        Optional<Rent> rent = rentRepository.findRent(username, itemId, rentDateId);
        rent.ifPresent(value -> entityManager.remove(value));

    }
}
