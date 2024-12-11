package org.ppke.itk.librarymanagementsystembackend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ppke.itk.librarymanagementsystembackend.controller.dto.ItemDto;
import org.ppke.itk.librarymanagementsystembackend.domain.Item;
import org.ppke.itk.librarymanagementsystembackend.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    /*



    private final ItemRepository itemRepository;

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/{id}")
    public ItemDto getItemById(@PathVariable("id") Integer id) {
        return ItemDto.fromItem(itemRepository.findById(id).get());
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("")
    public List<ItemDto> getItems(
            @RequestParam(required = false, defaultValue = "100") Integer limit,
            @RequestParam(required = false, defaultValue = "asc") String sort,
            @RequestParam(required = false) String bookTitle,
            @RequestParam(required = false) String condition,
            @RequestParam(required = false) String isAvailable
    ) {

        if (!sort.equalsIgnoreCase("desc") && !sort.equalsIgnoreCase("asc")) {
            throw new IllegalArgumentException("Invalid sorting param: " + sort + "!");
        }

        Specification<Item> specification = Specification.where(null);

        if (bookTitle != null) {
            specification.and(ItemRepository.containsKeywordInTitle(bookTitle));
        }

        if (condition != null) {
            specification.and(ItemRepository.checkCondition(condition));
        }

        if (isAvailable != null) {
            specification.and(ItemRepository.checkAvailability(isAvailable));
        }

        var sortParam = sort.equalsIgnoreCase("asc") ?
                Sort.by(Sort.Direction.ASC, "book.title", "id") :
                Sort.by(Sort.Direction.DESC, "book.title", "id");

        Page<Item> items = itemRepository.findAll(specification, PageRequest.of(0, limit, sortParam));

        return items.stream().
                map(ItemDto::fromItem).collect(Collectors.
                        toList());

    }

   @PutMapping("/{id}/available")
    ResponseEntity<Item> updateItemToAvailable(@PathVariable("id") Integer id) {
//        Optional<Item> itemToUpdate = itemRepository.findById(id);
        itemRepository.updateAvailability(true, id);
        return null;
    }

     */
}
