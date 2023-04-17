package com.practice.library.services;

import com.practice.library.entity.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {

    Book saveBook(Book book);
    Optional<Book> getBook(UUID id);
    Book updateBook(Book book, UUID id);
    void deleteBook(UUID id);
    List<Book> getAllBooks();
    List<Book> searchByTitle(String searchWord);
    List<Book> searchByAuthor(String searchWord);
    List<Book> searchByIsbn(String searchWord);

}
