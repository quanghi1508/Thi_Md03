package reponsitory;

import model.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> getAllBooks ();
}