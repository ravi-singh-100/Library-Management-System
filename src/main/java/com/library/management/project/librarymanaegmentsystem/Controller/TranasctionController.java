package com.library.management.project.librarymanaegmentsystem.Controller;


import com.library.management.project.librarymanaegmentsystem.Service.ServiceInterface.TransactionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TranasctionController {
    @Autowired
    TransactionInterface transactionInterface;
    @GetMapping("/issue")
    public ResponseEntity<String> issueBook(@RequestParam("bookId")int bookId,@RequestParam("studentId") int studentId) throws Exception {
        return transactionInterface.issueBook(bookId,studentId);
    }
    @GetMapping("/return")
    public ResponseEntity<String>returnBook(@RequestParam("bookId")int bookId,@RequestParam("studentId") int studentId) throws Exception{
        return transactionInterface.returnBook(bookId,studentId);
    }
}
