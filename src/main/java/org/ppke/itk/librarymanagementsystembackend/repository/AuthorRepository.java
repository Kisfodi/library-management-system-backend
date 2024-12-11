package org.ppke.itk.librarymanagementsystembackend.repository;

import org.ppke.itk.librarymanagementsystembackend.domain.Author;
import org.ppke.itk.librarymanagementsystembackend.domain.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("select a from Author a where upper(a.name) = upper(?1)")
    Optional<Author> findByNameIgnoreCase(String name);


    @Query("select a from Author a where a.name like concat('%', ?1, '%')")
    List<Author> findByNameContains(String name, Pageable pageable);

    @Override
    Optional<Author> findById(Integer integer);

    @Override
    List<Author> findAll();
}
