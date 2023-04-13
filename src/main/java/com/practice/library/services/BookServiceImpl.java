package com.practice.library.services;

import com.practice.library.models.Book;
import com.practice.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BookServiceImpl implements BookService {

    private final Logger LOGGER = Logger.getLogger(BookService.class.getName());

    @Autowired
    private BookRepository bookRepository;


    @Override
    public Optional<Book> getBook(Long id) {
       return bookRepository.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book, Long id) {
        Book bookToUpdate = bookRepository.findById(id).get();

        if (Objects.nonNull(book.getBookName()) && !"".equalsIgnoreCase(book.getBookName())) {
            bookToUpdate.setBookName(book.getBookName());
        }
        if (Objects.nonNull(book.getBookAuthor()) && !"".equalsIgnoreCase(book.getBookAuthor())) {
            bookToUpdate.setBookAuthor(book.getBookAuthor());
        }
        if (Objects.nonNull(book.getBookGenre()) && !"".equalsIgnoreCase(book.getBookGenre())) {
            bookToUpdate.setBookGenre(book.getBookGenre());
        }
        if (Objects.nonNull(book.getISBN()) && !"".equalsIgnoreCase(book.getISBN())) {
            bookToUpdate.setISBN(book.getISBN());
        }
        if (book.getLoanLength() != bookToUpdate.getLoanLength()) {
            bookToUpdate.setLoanLength(book.getLoanLength());
        }
        if (book.getCopiesAvailable() != bookToUpdate.getCopiesAvailable()) {
            bookToUpdate.setCopiesAvailable(book.getCopiesAvailable());
        }
        return bookRepository.save(bookToUpdate);
    }

    @Override
    public void deleteBook(Long id) {
        LOGGER.log(Level.INFO, "Deleting book: " + bookRepository.findById(id).toString());
        bookRepository.deleteById(id);
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
