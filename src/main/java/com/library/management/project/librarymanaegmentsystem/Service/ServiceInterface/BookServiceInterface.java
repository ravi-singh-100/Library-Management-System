package com.library.management.project.librarymanaegmentsystem.Service.ServiceInterface;

import com.library.management.project.librarymanaegmentsystem.Model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookServiceInterface {
    ResponseEntity<String> createBook(Book book);


    ResponseEntity<Book> getBookById(int bookId);


    ResponseEntity<List<Book>> getAllBook();
}
