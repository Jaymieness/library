package com.practice.library.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "bookName")
    private String bookName;

    @Column(name = "bookAuthor")
    private String bookAuthor;

    @Column(name = "bookGenre")
    private String bookGenre;

    @Column(name = "ISBN")
    private String ISBN;

    @Column(name = "copiesAvailable")
    private int copiesAvailable;

    @Column(name = "loanLength")
    private int loanLength;

    public Book(String bookName, String bookAuthor, String bookGenre, String ISBN, int copiesAvailable, int loanLength) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.ISBN = ISBN;
        this.copiesAvailable = copiesAvailable;
        this.loanLength = loanLength;
    }
}