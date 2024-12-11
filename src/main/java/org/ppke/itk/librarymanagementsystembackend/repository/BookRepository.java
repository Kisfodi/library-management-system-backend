package org.ppke.itk.librarymanagementsystembackend.repository;

import org.ppke.itk.librarymanagementsystembackend.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.function.Function;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {


    @Query("select b from Book b where upper(b.title) like upper(concat('%', ?1, '%'))")
    Page<Book> findByTitleContainsIgnoreCase(String title, Pageable pageable);


    @Query("select b from Book b where upper(b.author.name) like upper(concat('%', ?1, '%')) order by b.id")
    Page<Book> findByAuthor_NameContainsIgnoreCaseOrderByIdAsc(String name, Pageable pageable);

    @Query("select b from Book b where upper(b.genre) like upper(concat('%', ?1, '%')) order by b.id")
    Page<Book> findByGenreContainsIgnoreCaseOrderByIdAsc(String genre, Pageable pageable);

    Page<Book> findAll(Specification<Book> specification, Pageable pageable);

    @Query("select b from Book b where upper(b.author.name) = upper(:name)")
    List<Book> findByAuthor_NameIgnoreCase(@Param("name") String name);

    Page<Book> findAll(Pageable pageable);

    Optional<Book> findById(Integer id);


    static Specification<Book> containsKeywordInTitle(String keyword) {

        return (root, query, criteriaBuilder) ->
            criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + keyword.toLowerCase() + "%");

    }

    static Specification<Book> containsKeywordInAuthor(String keyword) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(criteriaBuilder.upper(root.get("author").get("name")), "%" + keyword.toUpperCase() + "%");
//                -> criteriaBuilder.like(root.get("author").get("name"), "%" + keyword + "%");

    }

    static Specification<Book> containsKeywordInGenre(String keyword) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(criteriaBuilder.upper(root.get("genre")), "%" + keyword.toUpperCase() + "%");
    }

    static Specification<Book> containsKeywordInYear(String keyword) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.upper(criteriaBuilder.toString(root.get("publicationYear"))), "%" + keyword.toUpperCase() + "%");
    }

    static Specification<Book> publicationYearBefore(String year) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("publicationYear"), Integer.parseInt(year));
    }

    static Specification<Book> publicationYearAfter(String year) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("publicationYear"), Integer.parseInt(year));
    }

    static Specification<Book> writtenBefore(String year) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("firstPublicationYear"), Integer.parseInt(year));
    }

    static Specification<Book> writtenAfter(String year) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("firstPublicationYear"), Integer.parseInt(year));
    }

    static Specification<Book> numOfPagesGreaterThan(String minOfPages) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("numberOfPages"), Integer.parseInt(minOfPages));
    }

    static Specification<Book> numOfPagesLessThan(String maxOfPages) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("numberOfPages"), Integer.parseInt(maxOfPages));
    }

    @Query("select count(distinct b) from Book b inner join b.items items where items.isAvailable = true")
    long countDistinctByItems_IsAvailableTrue();

    static Map<String, Function<String, Specification<Book>>> specificationMap = Map.ofEntries(
            Map.entry("title", BookRepository::containsKeywordInTitle),
            Map.entry("author", BookRepository::containsKeywordInAuthor),
            Map.entry("genre", BookRepository::containsKeywordInGenre),
            Map.entry("publication_year", BookRepository::containsKeywordInYear),
            Map.entry("num_of_pages_greater_than", BookRepository::numOfPagesGreaterThan),
            Map.entry("num_of_pages_less_than", BookRepository::numOfPagesLessThan),
            Map.entry("publication_year_before", BookRepository::publicationYearBefore),
            Map.entry("publication_year_after", BookRepository::publicationYearAfter),
            Map.entry("written_before", BookRepository::writtenBefore),
            Map.entry("written_after", BookRepository::writtenAfter)
    );

}