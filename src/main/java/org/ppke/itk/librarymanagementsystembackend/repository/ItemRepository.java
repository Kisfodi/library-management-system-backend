package org.ppke.itk.librarymanagementsystembackend.repository;

import org.ppke.itk.librarymanagementsystembackend.domain.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query("select i from Item i where i.isAvailable = ?1")
    List<Item> findByIsAvailable(Boolean isAvailable);

    @Query("select i from Item i where upper(i.book.title) like upper(concat('%', ?1, '%'))")
    List<Item> findByBook_TitleContainsIgnoreCase(String title, Pageable pageable);

    Optional<Item> findById(Integer id);


}
