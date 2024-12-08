package org.ppke.itk.librarymanagementsystembackend.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ppke.itk.librarymanagementsystembackend.domain.Book;
import org.ppke.itk.librarymanagementsystembackend.domain.Condition;
import org.ppke.itk.librarymanagementsystembackend.repository.BookRepository;
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
public class BookController {

    private final BookRepository bookRepository;
//    private final Book



//    TODO
//    Összetett filter
    @GetMapping("/books")
    public List<Book> getBooks(@RequestParam(required = false, defaultValue = "100") Integer limit,
                               @RequestParam(required = false, defaultValue = "desc") String sort) {
        if (!sort.equalsIgnoreCase("desc") && !sort.equalsIgnoreCase("asc")) {
            throw new IllegalArgumentException("Invalid sorting param!");
        }

        var sortParam = sort.equalsIgnoreCase("asc") ?
                Sort.by(Sort.Direction.ASC, "title") :
                Sort.by(Sort.Direction.DESC, "title");

        Page<Book> books = bookRepository.findAll(PageRequest.of(0, limit, sortParam));

        return books.toList();

    }

}
