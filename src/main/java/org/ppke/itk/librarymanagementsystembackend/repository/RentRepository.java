package org.ppke.itk.librarymanagementsystembackend.repository;

import org.ppke.itk.librarymanagementsystembackend.domain.Rent;
import org.ppke.itk.librarymanagementsystembackend.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RentRepository extends JpaRepository<Rent, Integer>, JpaSpecificationExecutor<Rent> {

    @Override
    Optional<Rent> findById(Integer id);

    Page<Rent> findAll(Pageable pageable);

//    @Query("select r from Rent r where r.userOfRent.username = ?1 and r.itemRented.id = ?2 and r.startDate = ?3")
//    Optional<Rent> findByUsernameAndItemRentedAndStartDate(String username, Integer id, LocalDate startDate);


    @Query("select r from Rent r where r.userOfRent.username = ?1 and r.itemRented.id = ?2")
    List<Rent> findByUserOfRentAndItemRented(String username, Integer id);

    @Query("""
            select r from Rent r
            where r.userOfRent.username = ?1 and r.itemRented.id = ?2 and r.rentDate.returnDate is null""")
    Optional<Rent> findNotReturnedRent(String username, Integer id);

//    @Query("""
//            select r from Rent r
//            where r.userOfRent.username = ?1 and r.itemRented.id = ?2 and r.rentDate.id is not null and r.rentDate.returnDate is null""")
//    Optional<Rent> findNotReturnedRent(String username, Integer id);


    @Query("select r from Rent r where r.userOfRent.username = ?1 and r.itemRented.id = ?2 and r.rentDate.id = ?3")
    Optional<Rent> findRent(String username, Integer id, Integer id1);

    List<Rent> findAllByUserOfRent(User userOfRent);

    static Specification<Rent> byUserOfRent(String username) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("userOfRent"), username);
    }

    static Specification<Rent> byItemRented(Integer itemId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("itemRented"), itemId);
    }

    static Specification<Rent> isReturned() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.isNotNull(root.get("returnDate"));
    }

    static Specification<Rent> isDeadlineExtended() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("numOfExtensions"), 0);
    }

}
