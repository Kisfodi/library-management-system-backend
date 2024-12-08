package org.ppke.itk.librarymanagementsystembackend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ppke.itk.librarymanagementsystembackend.domain.Author;
import org.ppke.itk.librarymanagementsystembackend.repository.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;

    @GetMapping("/authors")
    public List<Author> getAuthors(@RequestParam(required = false, defaultValue = "10") Integer limit,
                                   @RequestParam(required = false, defaultValue = "asc") String sort) {

        if (!sort.equalsIgnoreCase("desc") && !sort.equalsIgnoreCase("asc")) {
            throw new IllegalArgumentException("Invalid sort parameter");
        }

        Sort sortParam = sort.equalsIgnoreCase("desc") ? Sort.by(Sort.Direction.DESC) : Sort.by(Sort.Direction.ASC);

        Page<Author> authors = authorRepository.findAll(PageRequest.of(0, limit, sortParam));

        return authors.toList();

    }

//    @GetMapping("/author/{id}")

}
