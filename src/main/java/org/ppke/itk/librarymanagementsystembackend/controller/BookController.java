package org.ppke.itk.librarymanagementsystembackend.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ppke.itk.librarymanagementsystembackend.controller.dto.BookDto;
import org.ppke.itk.librarymanagementsystembackend.domain.Book;
import org.ppke.itk.librarymanagementsystembackend.repository.interfaces.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Tag(name = "Book")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;




//    TODO
//    Összetett filter
    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable("id") Integer id) {

//        Optional<Book> book = bookRepository.findById(id);

//        log.info(String.valueOf(book.get().getGenre()));

        return BookDto.fromBook(bookRepository.findById(id).orElseThrow());
    }

    @Operation(summary = "Retrieves a list of books based on several different parameters",
            description = """
             This request allows for a slightly more advanced filtering and sorting.
                            1. Sorting
                                - 'sortKeyword': defines the column based on which we would like to sort
                                - 'sort': defines if sorting is done in an ascending (asc) or descending (desc) order
                            2. Filtering is done with the following 3 parameters
                                - 'filterKeyword': list of strings which contains the attributes we want to use for filtering
                                - 'filterValue': list of Strings that contains the values of the different filter
                                - 'filterOperator': list of Strings that define the logic of the search
            """ )
    @GetMapping("")
    public List<BookDto> getBooks(
            @RequestParam(required = false, defaultValue = "100") Integer limit,
            @RequestParam(required = false, defaultValue = "0") Integer currentPageNumber,
            @RequestParam(required = false, defaultValue = "asc") String sort,
            @RequestParam(required = false, defaultValue = "id") String sortKeyWord,
            @RequestParam(required = false) List<String> filterKeyword,
            @RequestParam(required = false) List<String> filterValue,
            @RequestParam(required = false) List<String> filterOperator
            ) {

        if (filterKeyword != null && filterValue != null && filterOperator != null) {


            Assert.state(filterKeyword.size() == filterValue.size(),
                    "These will be paired together");
            Assert.state(filterKeyword.size() == filterOperator.size() + 1,
                    "Inconsistency between filter map and operators");


            filterOperator.addFirst("and");
            
            Assert.state(filterOperator.stream().noneMatch(
                    item -> !item.equalsIgnoreCase("and") && !item.equalsIgnoreCase("or")),
                    "Invalid operator values");

        } else if (filterKeyword != null && filterValue != null) {
            filterOperator = List.of("or");
            Assert.state(filterKeyword.size() == filterValue.size(), "There should be key-value pairs after each other!");
            Assert.state(filterKeyword.size() < 2, "There should be only one pair if there are no operators!");
        } else {
            filterKeyword = Collections.emptyList();
            filterValue = Collections.emptyList();
            filterOperator = Collections.emptyList();
        }

        if (!sort.equalsIgnoreCase("desc") && !sort.equalsIgnoreCase("asc")) {
            throw new IllegalArgumentException("Invalid sorting param: " + sort + "!");
        }

        List<List<String>> filterMap = new ArrayList<>();
        for (int i = 0; i < filterKeyword.size(); i++) {
            log.info("Index: {}", i);
            List<String> temp = List.of(filterKeyword.get(i), filterValue.get(i));
            filterMap.add(temp);

        }

        Specification<Book> specification = Specification.where(null);

        for (int i = 0; i < filterMap.size(); i++) {
            Specification<Book> current_filter = getBookSpecification(filterMap, i);

            String logicalOperator = filterOperator.get(i);
                if (logicalOperator.equalsIgnoreCase("and")) {
                    specification = specification.and(current_filter);
                } else if (logicalOperator.equalsIgnoreCase("or")) {
                    specification = specification.or(current_filter);
                }

        }

        if ((sortKeyWord != null) &&
                (
                        !sortKeyWord.equalsIgnoreCase("id") &&
                        !sortKeyWord.equalsIgnoreCase("title") &&
                        !sortKeyWord.equalsIgnoreCase("author.name") &&
                        !sortKeyWord.equalsIgnoreCase("genre") &&
                        !sortKeyWord.equalsIgnoreCase("numberOfPages") &&
                        !sortKeyWord.equalsIgnoreCase("publicationYear") &&
                        !sortKeyWord.equalsIgnoreCase("firstPublicationYear")
                )
        ) {
            throw new IllegalArgumentException("Invalid sort keyword: " + sortKeyWord);
        }

        var sortParam = sort.equalsIgnoreCase("asc") ?
                Sort.by(Sort.Direction.ASC, sortKeyWord) :
                Sort.by(Sort.Direction.DESC, sortKeyWord);


        Page<Book> books = bookRepository.findAll(specification, PageRequest.of(currentPageNumber, limit, sortParam));

        log.info("Size of result: {}", books.getSize());

        return books.stream()
                .map(BookDto::fromBook)
                .toList();
    }

    private static Specification<Book> getBookSpecification(List<List<String>> filterMap, int i) {
        List<String> filterElement = filterMap.get(i);

        var currentFunction = BookRepository.specificationMap.get(filterElement.getFirst());

        if (currentFunction != null)
            return currentFunction.apply(filterElement.getLast());
        else
            throw new IllegalArgumentException("Invalid filter element: " + filterElement.getFirst());

    }

    @GetMapping(value = "{id}/image", produces = "image/png")
    public @ResponseBody byte[] getBookCover(@PathVariable("id") Integer id) throws IOException {

        var book = bookRepository.findById(id);

        String image_path;
        if (book.isPresent()) {

            image_path = "/static/images/books/" + book.get().getCoverPath();
        } else {
            throw new NoSuchElementException("Book with id " + id + " not found!");
        }

        try {

            InputStream in = getClass()
                    .getResourceAsStream(image_path);
            return in.readAllBytes();
        } catch (IOException e) {
            image_path = "/static/images/common/no_image_placeholder.png";
            InputStream in = getClass()
                    .getResourceAsStream(image_path);
            return in.readAllBytes();
        }

    }

}
