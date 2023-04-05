package com.practice.library.repository;

import com.practice.library.models.*;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, String> {

  List<Book> findAll();
}
