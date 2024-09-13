package service;


import model.Book;
import reponsitory.BookRepository;
import reponsitory.IBookRepository;

import java.util.List;

public class BookService implements IBookService{
    IBookRepository iBookRepository = new BookRepository();
    @Override
    public List<Book> getAllBooks() {
        return iBookRepository.getAllBooks();
    }
}

