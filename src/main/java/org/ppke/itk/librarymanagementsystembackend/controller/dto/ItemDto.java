package org.ppke.itk.librarymanagementsystembackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ppke.itk.librarymanagementsystembackend.domain.Item;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private Integer id;
    private BookDto book;
    private Boolean isAvailable;
    private String condition;

    public static ItemDto fromItem(Item item) {
        return new ItemDto(
                item.getId(),
                BookDto.fromBook(item.getBook()),
//                item.getBook().getTitle(),
                item.getIsAvailable(),
                item.getCondition().getCondition());
    }


}
