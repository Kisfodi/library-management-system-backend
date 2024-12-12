package org.ppke.itk.librarymanagementsystembackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ppke.itk.librarymanagementsystembackend.domain.Book;
import org.ppke.itk.librarymanagementsystembackend.domain.Condition;
import org.ppke.itk.librarymanagementsystembackend.domain.Genre;
import org.ppke.itk.librarymanagementsystembackend.domain.Item;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private Integer id;
    private String bookTitle;

    private Boolean isAvailable;
    private Condition condition;

    public static ItemDto fromItem(Item item) {
        return new ItemDto(
                item.getId(),
                item.getBook().getTitle(),
                item.getIsAvailable(),
                item.getCondition());
    }


}
