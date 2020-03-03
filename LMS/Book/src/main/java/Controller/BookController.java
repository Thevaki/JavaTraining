package Controller;

import Model.Book;
import Service.BookService;
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
        return bookService.save(book);
    }

    @RequestMapping(value="/findBook/{id}",method = RequestMethod.POST)
    public Book findEmployee(@PathVariable("id") Integer id){
        return bookService.findBook(id);
    }

    @RequestMapping(value="/fetchAllBooks",method = RequestMethod.GET)
    public List<Book> fetchAllEmployees(){
        return bookService.fetchAllBooks();
    }

}
