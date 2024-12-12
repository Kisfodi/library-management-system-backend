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
import org.springframework.data.jpa.repository.Modifying;
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
        } else if (!item.get().getIsAvailable()) {
            throw new IllegalStateException("Item is not available!");
        }

        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new NoSuchElementException("No user found with name " + username);
        }

        List<Rent> existingRent = rentRepository.findNotReturnedRent(itemId);
        if (!existingRent.isEmpty()) {
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
    public void deleteRent(Integer itemId, String username) {
        Optional<Rent> rent = rentRepository.findNotReturnedByUserRent(username, itemId);

        if (rent.isPresent()) {

            Item item = rent.get().getItemRented();
            itemRepository.updateAvailability(true, item.getId());
            rent.get().setItemRented(entityManager.merge(item));
            entityManager.remove(rent.get());

        }

        else
            throw new NoSuchElementException("No such rent found!");

//        rent?.ifPresent(value -> entityManager.remove(value));

    }

    @Override
    @Transactional
    public void returnRent(Integer itemId, String username) {

        Optional<Item> item = itemRepository.findById(itemId);
        if (item.isEmpty()) {
            throw new NoSuchElementException("No item found with id " + itemId);
        } else if (item.get().getIsAvailable()) {
            throw new IllegalStateException("Item is not rented by anyone!");
        }

        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new NoSuchElementException("No user found with name " + username);
        }

        Optional<Rent> existingRent = rentRepository.findNotReturnedByUserRent(username, itemId);

        if (existingRent.isPresent()) {
            Item itemOfRent = existingRent.get().getItemRented();
            itemRepository.updateAvailability(true, itemOfRent.getId());
            existingRent.get().setItemRented(entityManager.merge(itemOfRent));

            RentDate rentDate = existingRent.get().getRentDate();
            rentDate.setReturnDate(LocalDateTime.now());

            existingRent.get().setRentDate(entityManager.merge(rentDate));

            entityManager.persist(existingRent.get());

        } else {
            throw new NoSuchElementException("No such item has been rented by " + username);
        }

    }

    @Override
    @Transactional
    public void extendDeadline(Integer itemId, String username) {
        Optional<Item> item = itemRepository.findById(itemId);
        if (item.isEmpty()) {
            throw new NoSuchElementException("No item found with id " + itemId);
        } else if (item.get().getIsAvailable()) {
            throw new IllegalStateException("Item is not rented by anyone!");
        }

        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new NoSuchElementException("No user found with name " + username);
        }

        Optional<Rent> existingRent = rentRepository.findNotReturnedByUserRent(username, itemId);

        if (existingRent.isPresent()) {
//            Item itemOfRent = existingRent.get().getItemRented();
//            itemRepository.updateAvailability(true, itemOfRent.getId());
//            existingRent.get().setItemRented(entityManager.merge(itemOfRent));

            RentDate rentDate = existingRent.get().getRentDate();
            rentDate.setDeadline(rentDate.getDeadline().plusWeeks(1));
            existingRent.get().setRentDate(entityManager.merge(rentDate));
            existingRent.get().setNumOfExtensions(existingRent.get().getNumOfExtensions() + 1);

            entityManager.persist(existingRent.get());

        } else {
            throw new NoSuchElementException("No such item has been rented by " + username);
        }
    }
}
