package org.ppke.itk.librarymanagementsystembackend.repository.interfaces;

import org.ppke.itk.librarymanagementsystembackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
