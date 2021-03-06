package com.libraryManagementSystem.Book.Service;

import com.libraryManagementSystem.Book.Model.Book;
import com.libraryManagementSystem.Book.Repository.BookRepository;
import com.libraryManagementSystem.Book.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Book editBook(Book book){return bookRepository.save(book);}

    public Book deleteBook(Integer id){
        Optional<Book> book = bookRepository.findById(id);

        if(book.isPresent()) {
            bookRepository.deleteById(id);
            return book.get();
        }
        return null;

    }

    public Book findBook(Integer id){
        Optional<Book> book = bookRepository.findById(id);

        if(book.isPresent()) {
            return book.get();
        }
        return null;
    }

    public List<Book> fetchAllBooks(){
        List<Book> books = bookRepository.findAll();

        if(books.isEmpty()){
            return null;
        }
        return  books;
    }
}
