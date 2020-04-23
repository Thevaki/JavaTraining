package com.libraryManagementSystem.Book.Service;

import com.libraryManagementSystem.Book.Model.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);

    Book editBook(Book book);

    Book deleteBook(Integer id);

    Book findBook(Integer id);

    List<Book> fetchAllBooks();

    List<Book> searchBooks(String title);

    List<Book> categoryBooks(String category);
}
