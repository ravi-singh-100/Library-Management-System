package com.library.management.project.librarymanaegmentsystem.Controller;

import com.library.management.project.librarymanaegmentsystem.Model.Book;
import com.library.management.project.librarymanaegmentsystem.ModelWrapper.BookWrapper;
import com.library.management.project.librarymanaegmentsystem.Service.ServiceInterface.BookServiceInterface;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookServiceInterface bookServiceInterface;
    @PostMapping("/createBook")
    public  ResponseEntity<String> createBook(@Valid @RequestBody BookWrapper bookWrapper){
        return bookServiceInterface.createBook(bookWrapper.bookWrapperToBook());
    }
    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable("bookId") int bookId){
        return bookServiceInterface.getBookById(bookId);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBoook(){
        return bookServiceInterface.getAllBook();
    }

}
