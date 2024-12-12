package org.ppke.itk.librarymanagementsystembackend.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ppke.itk.librarymanagementsystembackend.controller.dto.RentDto;
import org.ppke.itk.librarymanagementsystembackend.domain.Rent;
import org.ppke.itk.librarymanagementsystembackend.repository.interfaces.CustomRentRepository;
import org.ppke.itk.librarymanagementsystembackend.repository.interfaces.RentRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Rent")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/rents")
public class RentController {

    private final RentRepository rentRepository;
    private final CustomRentRepository customRentRepository;

    @GetMapping("")
    List<RentDto> getRents(
            @RequestParam(required = false) String user,
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String isAvailable,
            @RequestParam(required = false) boolean checkReturnDate,
            @RequestParam(required = false) boolean isDeadlineExtended
    ) {

        Specification<Rent> specification = Specification.where(null);

        if (user != null) {
            specification = specification.and(RentRepository.byUserOfRent(user));
        }

        if (id != null) {
            specification = specification.and(RentRepository.byItemRented(id));
        }

        if (isAvailable != null) {
            specification = specification.and(RentRepository.checkAvailability(isAvailable));
        }

        if (checkReturnDate) {
            specification = specification.and(RentRepository.checkReturned());
        }

        if (isDeadlineExtended) {
            specification = specification.and(RentRepository.isDeadlineExtended());
        }

        return rentRepository.findAll(specification).stream().map(RentDto::fromRent)
                .toList();

    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/{id}")
    public Rent getRentById(@PathVariable("id") Integer id) {
        return rentRepository.findById(id).get();
    }

    @GetMapping(value = "/{username}/{itemId}")
    public List<RentDto> getRent(@PathVariable("username") String username, @PathVariable("itemId") Integer itemId) {

        List<Rent> rents = rentRepository.findByUserOfRentAndItemRented(username, itemId);

        return rents.stream().map(RentDto::fromRent).toList();

    }

    @Secured("ROLE_ADMIN")
    @PostMapping(value = "/{username}/{itemId}")
    public RentDto saveRent(@PathVariable("username") String username, @PathVariable("itemId") Integer itemId) {
        Rent rent = customRentRepository.saveRent(itemId, username);

        log.info(rent.toString());

        return RentDto.fromRent(rent);

    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = "/{username}/{itemId}")
    public void deleteRent(@PathVariable("username") String username,
                           @PathVariable("itemId") Integer itemId
                           ) {
        customRentRepository.deleteRent(itemId, username);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping(value = "/{username}/{itemId}")
    public void returnItem(
            @PathVariable("username") String username,
            @PathVariable("itemId") Integer itemId
    ) {
        customRentRepository.returnRent(itemId, username);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("extend/{username}/{itemId}")
    public ResponseEntity<String> extendDeadline(
            @PathVariable("username") String username,
            @PathVariable("itemId") Integer itemId
    ) {

        try {
            customRentRepository.extendDeadline(itemId, username);
            return ResponseEntity.ok("Deadline successfully extended");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }




}
