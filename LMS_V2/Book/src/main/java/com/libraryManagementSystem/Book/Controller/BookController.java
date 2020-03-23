package com.libraryManagementSystem.Book.Controller;

import com.libraryManagementSystem.Book.Model.Book;
import com.libraryManagementSystem.Book.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@RestController
@RequestMapping("/Book")
@XmlRootElement
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/createBook" , method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @RequestMapping(value = "/editBook",method = RequestMethod.PUT)
    public Book editBook(@RequestBody Book book){return bookService.editBook(book);}

    @RequestMapping(value = "/deleteBook/{id}",method = RequestMethod.DELETE)
    public Book deleteBook(@PathVariable("id") Integer id){return bookService.deleteBook(id);}

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/findBook/{id}",method = RequestMethod.GET)
    public Book findBook(@PathVariable("id") Integer id){
        return bookService.findBook(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/fetchAllBooks",method = RequestMethod.GET)
    public List<Book> fetchAllBooks(){
        return bookService.fetchAllBooks();
    }

}
