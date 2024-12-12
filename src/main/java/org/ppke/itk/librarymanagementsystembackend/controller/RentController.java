package org.ppke.itk.librarymanagementsystembackend.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ppke.itk.librarymanagementsystembackend.controller.dto.RentDto;
import org.ppke.itk.librarymanagementsystembackend.domain.Rent;
import org.ppke.itk.librarymanagementsystembackend.repository.CustomRentRepository;
import org.ppke.itk.librarymanagementsystembackend.repository.RentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Tag(name = "Rent")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/rents")
public class RentController {

    private final RentRepository rentRepository;
    private final CustomRentRepository customRentRepository;

    @GetMapping("")
    List<RentDto> getRents() {
        return rentRepository.findAll().stream().map(RentDto::fromRent).toList();
    }

    @GetMapping("/{id}")
    public Rent getRentById(@PathVariable("id") Integer id) {
        return rentRepository.findById(id).get();
    }

    @GetMapping(value = "/{username}/{itemId}")
    public List<RentDto> getRent(@PathVariable("username") String username, @PathVariable("itemId") Integer itemId) {

        List<Rent> rents = rentRepository.findByUserOfRentAndItemRented(username, itemId);

        return rents.stream().map(RentDto::fromRent).toList();

    }

    @PostMapping(value = "/{username}/{itemId}")
    public RentDto saveRent(@PathVariable("username") String username, @PathVariable("itemId") Integer itemId) {
        Rent rent = customRentRepository.saveRent(itemId, username);

        log.info(rent.toString());

        return RentDto.fromRent(rent);

    }

    @DeleteMapping(value = "/{username}/{itemId}/{rentDateId}")
    public void deleteRent(@PathVariable("username") String username,
                           @PathVariable("itemId") Integer itemId,
                           @PathVariable("rentDateId") Integer rentDateId) {
        customRentRepository.deleteRent(itemId, username, rentDateId);
    }


}
