package com.practice.library.repository;

import com.practice.library.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface
BookRepository extends JpaRepository<Book, Long> {

  List<Book> findAll();
  List<Book> searchBookByBookNameContaining(String searchWord);
  List<Book> searchBookByBookAuthorContaining(String searchWord);
  List<Book> searchBookByISBN(String searchWord);
  Optional<Book> findById(Long id);
}
