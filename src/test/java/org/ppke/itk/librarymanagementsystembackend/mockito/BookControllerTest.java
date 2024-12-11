package org.ppke.itk.librarymanagementsystembackend.mockito;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ppke.itk.librarymanagementsystembackend.controller.BookController;
import org.ppke.itk.librarymanagementsystembackend.domain.Book;
import org.ppke.itk.librarymanagementsystembackend.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookController bookController;

}
