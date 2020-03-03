package com.libraryManagementSystem.Book.Service;

import com.libraryManagementSystem.Book.Model.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);

    Book findBook(int id);

    List<Book> fetchAllBooks();
}
