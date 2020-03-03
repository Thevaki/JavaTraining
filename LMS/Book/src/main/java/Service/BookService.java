package Service;

import Model.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);

    Book findBook(int id);

    List<Book> fetchAllBooks();
}
