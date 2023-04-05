package com.practice.library;

import com.practice.library.models.*;

import com.practice.library.repository.BookRepository;
import com.practice.library.services.BookService;
import com.practice.library.services.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;



public class BooksUnitTest {

    private BookService bookService;
    private BookRepository bookRepository;
    private List<Book> books;

    @BeforeEach
    void setUp() {
        bookService = new BookServiceImpl();
        books = new ArrayList<>();
    }

    @Test
    void seeListOfAllBooks() {
        List<Book> booksAvailable = bookService.getAllBooks();
        assertEquals(5, books.size());
    }

}