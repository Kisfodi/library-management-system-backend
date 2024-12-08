package org.ppke.itk.librarymanagementsystembackend.repository;

import org.ppke.itk.librarymanagementsystembackend.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {


    Page<Book> findAllByTitleContainingIgnoreCase(String title, Pageable pageable);

    Page<Book> findBookByAuthorContaining(String author, Pageable pageable);

    Page<Book> findAll(Pageable pageable);

    @Query("select count(distinct b) from Book b inner join b.items items where items.isAvailable = true")
    long countDistinctByItems_IsAvailableTrue();

//TODO
//    If I want to sort by arbitrary attribute, how can I do that
//    PUT: Update in custom repository?
//    Advanced "search" --> Multiple GET requests after each other?

}