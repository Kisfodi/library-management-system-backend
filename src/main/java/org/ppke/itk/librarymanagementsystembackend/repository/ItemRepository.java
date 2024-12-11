package org.ppke.itk.librarymanagementsystembackend.repository;

import org.ppke.itk.librarymanagementsystembackend.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer>, JpaSpecificationExecutor<Item> {

//    @Transactional
//    @Modifying
//    @Query("update Item i set i.isAvailable = ?1 where i.id = ?2")
//    int updateIsAvailableById(Boolean isAvailable, Integer id);

    @Transactional
    @Modifying
    @Query("update Item i set i.isAvailable = ?1 where i.id = ?2")
    void updateAvailability(Boolean isAvailable, Integer id);

    @Query("select i from Item i where i.id = :id and i.isAvailable = true")
    Optional<Item> findAvailableItem(@Param("id") Integer id);


    @Query("select i from Item i where i.isAvailable = ?1")
    List<Item> findByIsAvailable(Boolean isAvailable);

    @Query("select i from Item i where upper(i.book.title) like upper(concat('%', ?1, '%'))")
    List<Item> findByBook_TitleContainsIgnoreCase(String title, Pageable pageable);

    Optional<Item> findById(Integer id);

    Page<Item> findAll(Specification<Item> specification, Pageable pageable);

    static Specification<Item> containsKeywordInTitle(String keyword) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.upper(root.get("book").get("title")), "%" + keyword.toUpperCase() + "%");
    }

    static Specification<Item> checkAvailability(String isAvailable) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("isAvailable"), Boolean.parseBoolean(isAvailable));
    }

    static Specification<Item> checkCondition(String condition) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("condition"), condition);
    }

}
