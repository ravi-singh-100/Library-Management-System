package com.library.management.project.librarymanaegmentsystem.Service.ServiceInterface;

import org.springframework.http.ResponseEntity;

public interface TransactionInterface {
    ResponseEntity<String> issueBook(int bookId,int studentId) throws Exception;
    ResponseEntity<String>returnBook(int bookId,int studentId) throws Exception;
}
