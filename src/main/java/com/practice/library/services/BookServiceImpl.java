package com.practice.library.services;

import com.practice.library.models.Book;
import com.practice.library.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BookServiceImpl implements BookService {

    private final Logger LOGGER = Logger.getLogger(BookService.class.getName());

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        LOGGER.log(Level.INFO, "Returning all books currently available to loan out.");

        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchByTitle(String searchWord) {
       return bookRepository.searchBookByBookNameContaining(searchWord);
    }

    @Override
    public List<Book> searchByAuthor(String searchWord) {
        return bookRepository.searchBookByBookAuthorContaining(searchWord);
    }

    @Override
    public List<Book> searchByIsbn(String searchWord) {
        return bookRepository.searchBookByISBN(searchWord);
    }
}
