package com.library.management.project.librarymanaegmentsystem.Service.implementor;

import com.library.management.project.librarymanaegmentsystem.Model.Author;
import com.library.management.project.librarymanaegmentsystem.Model.Book;
import com.library.management.project.librarymanaegmentsystem.Repository.BookRepo;
import com.library.management.project.librarymanaegmentsystem.Service.ServiceInterface.AuthorServiceInterface;
import com.library.management.project.librarymanaegmentsystem.Service.ServiceInterface.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookServiceInterface {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    AuthorServiceInterface authorServiceInterface;
    public ResponseEntity<String>createBook(Book book){
        Author authorFromDB= authorServiceInterface.getOrCreateAuthor(book.getAuthor());
        book.setAuthor(authorFromDB);
        bookRepo.save(book);
        return new ResponseEntity<>("Success", HttpStatusCode.valueOf(201));
    }

    @Override
    public Book getBookById(int bookId) {
        Book book=bookRepo.findById(bookId).orElse(null);
     return book;
//      return new ResponseEntity<>(book,HttpStatusCode.valueOf(200));
    }

    @Override
    public ResponseEntity<List<Book>> getAllBook() {
        return new ResponseEntity<>(bookRepo.findAll(),HttpStatusCode.valueOf(200));
    }
}
