package org.ppke.itk.librarymanagementsystembackend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ppke.itk.librarymanagementsystembackend.domain.Rent;
import org.ppke.itk.librarymanagementsystembackend.repository.RentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RentController {

    private final RentRepository rentRepository;

    @GetMapping("rents/{id}")
    public Rent getRentById(@PathVariable("id") Integer id) {
        return rentRepository.findById(id).get();
    }

}
