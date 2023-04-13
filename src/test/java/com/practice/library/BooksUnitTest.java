package com.practice.library;

import com.practice.library.models.*;

import com.practice.library.repository.BookRepository;
import com.practice.library.services.BookService;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BooksUnitTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    private List<Book> booksAvailable;


    @BeforeAll
    void setUp() {
        bookRepository.save(new Book("The Silver Chair: Chronicles of Narnia", "C.S. Lewis", "Fantasy", "978-0006716815", 2, 1));
        bookRepository.save(new Book("Night Watch", "Terry Pratchett", "Fantasy", "978-0552148993", 5, 2));
        bookRepository.save(new Book("The Life And Times Of The Thunderbolt Kid: Travels Through my Childhood", "Bill Bryson",
                "Biography", "978-0552772549", 3, 1));
        bookRepository.save(new Book("The Fourth Pillar of Sustainability: Culture's Essential Role in Public Planning", "Jon Hawkes",
                "Non-Fiction", "978-1863350501", 1, 2));
        bookRepository.save(new Book("Sabriel: Abhorsen Series", "Garth Nix", "Fantasy", "978-0007137312", 2, 1));
        bookRepository.save(new Book("Interesting Times", "Terry Pratchett", "Fantasy", "978-0552142359", 2, 1));
    }

    @Test
    void seeListOfAllBooks() {
        booksAvailable = bookService.getAllBooks();
        assertEquals(6, booksAvailable.size());
    }

    @Test
    void searchBooksViaTitle() {
        List<Book> searchedBooks = bookService.searchByTitle("Times");
        assertEquals(2, searchedBooks.size());
    }

    @Test
    void searchBooksViaAuthor() {
        List<Book> searchedBooks = bookService.searchByAuthor("Lewis");
        assertEquals(1, searchedBooks.size());
    }

    @Test
    void searchByIsbn() {
        List<Book> searchedBooks = bookService.searchByIsbn("978-0007137312");
        assertEquals(1, searchedBooks.size());
    }

}