package com.practice.library.services;

import com.practice.library.models.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    List<Book> searchByTitle(String searchWord);
    List<Book> searchByAuthor(String searchWord);
    List<Book> searchByIsbn(String searchWord);
    Book saveBook(Book book);
}
