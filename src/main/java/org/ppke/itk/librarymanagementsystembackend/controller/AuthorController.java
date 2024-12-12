package org.ppke.itk.librarymanagementsystembackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ppke.itk.librarymanagementsystembackend.controller.dto.AuthorDto;
import org.ppke.itk.librarymanagementsystembackend.domain.Author;
import org.ppke.itk.librarymanagementsystembackend.domain.Genre;
import org.ppke.itk.librarymanagementsystembackend.repository.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Tag(name = "Author")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Operation(summary = "Retrieve author given by id")
    @GetMapping(value = "/{id}")
    public AuthorDto getAuthorById(@PathVariable("id") Integer id) {

        Optional<Author> author = authorRepository.findById(id);

        if (author.isPresent()) {
            return AuthorDto.fromAuthor(author.get());
        } else throw new NoSuchElementException("Author not found");

    }

    @Operation(summary = "Retrieve list of authors")
    @GetMapping("")
    public List<AuthorDto> getAuthors() {

        return authorRepository.findAll().stream()
                .map(AuthorDto::fromAuthor)
                .toList();

    }

    @GetMapping(value = "/{id}", produces = "image/png")
    @Operation(summary = "Return portrait of the author given by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get portrait of given author"),
            @ApiResponse(responseCode = "404", description = "Image path is not found")
    })
    public @ResponseBody byte[] getAuthorPortrait(@PathVariable("id") Integer id) throws IOException {

        var author = authorRepository.findById(id);

        String image_path;
        if (author.isPresent()) {
            image_path = "/static/images/authors/" + author.get().getPortraitPath();
        } else {
            throw new NoSuchElementException("Author not found");

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

    /*
     */

}
