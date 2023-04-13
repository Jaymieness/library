package com.practice.library.services;

import com.practice.library.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book saveBook(Book book);
    Optional<Book> getBook(Long id);
    Book updateBook(Book book, Long id);
    void deleteBook(Long id);
    List<Book> getAllBooks();
    List<Book> searchByTitle(String searchWord);
    List<Book> searchByAuthor(String searchWord);
    List<Book> searchByIsbn(String searchWord);

}
