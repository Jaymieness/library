package com.practice.library.models;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

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

    public Book() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public int getLoanLength() {
        return loanLength;
    }

    public void setLoanLength(int loanLength) {
        this.loanLength = loanLength;
    }
}