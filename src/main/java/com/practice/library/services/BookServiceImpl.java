package com.practice.library.services;

import com.practice.library.models.Book;
import com.practice.library.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class BookServiceImpl implements BookService {

    private final Logger LOGGER = Logger.getLogger(BookService.class.getName());

    @Autowired
    private BookRepository bookRepository;

//    @PostConstruct
//    public void instantiateBookDatabase() {
//
//        LOGGER.info("Book database creation started.");
//        bookRepository.save(new Book ("The Silver Chair: Chronicles of Narnia", "C.S. Lewis","Fantasy", "978-0006716815", 2, 1));
//        bookRepository.save(new Book ("Night Watch", "Terry Pratchett", "Fantasy", "978-0552148993", 5, 2));
//        bookRepository.save(new Book ("The Life And Times Of The Thunderbolt Kid: Travels Through my Childhood", "Bill Bryson",
//                "Biography", "978-0552772549", 3, 1));
//        bookRepository.save(new Book ("The Fourth Pillar of Sustainability: Culture's Essential Role in Public Planning", "Jon Hawkes",
//                "Non-Fiction", "978-1863350501", 1, 2));
//        bookRepository.save(new Book ("Sabriel: Abhorsen Series", "Garth Nix", "Fantasy", "978-0007137312", 2, 1));
//        LOGGER.info("Book database completed.");
//    }

    @Override
    public List<Book> getAllBooks() {
        LOGGER.log(Level.INFO, "Returning all books currently available to loan out.");
        return bookRepository.findAll();
    }
}
