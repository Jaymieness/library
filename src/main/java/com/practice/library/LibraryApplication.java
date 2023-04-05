package com.practice.library;

import com.practice.library.models.Book;
import com.practice.library.repository.BookRepository;
import com.practice.library.services.BookService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;


@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	private BookRepository bookRepository;
	private final Logger LOGGER = Logger.getLogger(BookService.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Book database creation started.");
		bookRepository.save(new Book ("The Silver Chair: Chronicles of Narnia", "C.S. Lewis","Fantasy", "978-0006716815", 2, 1));
		bookRepository.save(new Book ("Night Watch", "Terry Pratchett", "Fantasy", "978-0552148993", 5, 2));
		bookRepository.save(new Book ("The Life And Times Of The Thunderbolt Kid: Travels Through my Childhood", "Bill Bryson",
				"Biography", "978-0552772549", 3, 1));
		bookRepository.save(new Book ("The Fourth Pillar of Sustainability: Culture's Essential Role in Public Planning", "Jon Hawkes",
				"Non-Fiction", "978-1863350501", 1, 2));
		bookRepository.save(new Book ("Sabriel: Abhorsen Series", "Garth Nix", "Fantasy", "978-0007137312", 2, 1));
		LOGGER.info("Book database completed.");

	}

}

