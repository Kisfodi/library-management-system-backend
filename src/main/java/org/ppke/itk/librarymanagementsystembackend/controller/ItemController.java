package org.ppke.itk.librarymanagementsystembackend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ppke.itk.librarymanagementsystembackend.domain.Item;
import org.ppke.itk.librarymanagementsystembackend.repository.ItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping("/items/{id}")
    public Item getItemById(@PathVariable("id") Integer id) {
        return itemRepository.findById(id).get();
    }

}
