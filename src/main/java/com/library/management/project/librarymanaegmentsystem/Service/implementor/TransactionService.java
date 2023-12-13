package com.library.management.project.librarymanaegmentsystem.Service.implementor;

import com.library.management.project.librarymanaegmentsystem.Model.*;
import com.library.management.project.librarymanaegmentsystem.Repository.TransactionRepo;
import com.library.management.project.librarymanaegmentsystem.Service.ServiceInterface.BookServiceInterface;
import com.library.management.project.librarymanaegmentsystem.Service.ServiceInterface.StudentServiceInterface;
import com.library.management.project.librarymanaegmentsystem.Service.ServiceInterface.TransactionInterface;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService implements TransactionInterface {

    @Value("${student.book.limit}")
    int studentBookLimit;
    @Value("${book.fine.days}")
    int fineAfterDays;
    @Value("${book.fine.cost}")
    int finePerDay;
    @Autowired
    TransactionRepo transactionRepo;
    @Autowired
    StudentServiceInterface studentServiceInterface;
    @Autowired
    BookServiceInterface bookServiceInterface;
    @Override
    public ResponseEntity<String> issueBook(int bookId, int studentId) throws Exception {
        Student student=studentServiceInterface.getStudentById(studentId);
        Book book=bookServiceInterface.getBookById(bookId);
        if(student==null){
            throw new Exception("Unable to issue book bcz student is not present");
        }
        else if(student.getBookList().size()>=2){
            throw new Exception("Unale to issue book bcz Student cannot issue more than two book");

        }

        else if(book==null){
            throw new Exception("Unale to issue book bcz book is not present in the Systen");
        }
        else if(book.getStudent()!=null){
            throw new Exception("Unable to issue book bcz someone else having it");
        }

        Transaction transaction=Transaction.builder().transactionType(TransactionType.ISSUE)
                .transactionId(UUID.randomUUID().toString())
                .transactionStatus(TransactionStatus.PENDING)
                .student(student)
                .book(book)
                .fine(0)
                .build();
        transactionRepo.save(transaction);
        try{
         book.setStudent(student);
         bookServiceInterface.createBook(book);
         transaction.setTransactionStatus(TransactionStatus.SUCCESS);
         transactionRepo.save(transaction);
        }
        catch(Exception e){
book.setStudent(null);
            bookServiceInterface.createBook(book);
transaction.setTransactionStatus(TransactionStatus.FAILED);
transactionRepo.save(transaction);
        }

        return new ResponseEntity<>("Succes TransactionId -> "+transaction.getTransactionId(), HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<String>returnBook(int bookId, int studentId) throws Exception {
        Book book=bookServiceInterface.getBookById(bookId);
        Student student=studentServiceInterface.getStudentById(studentId);
        if(book==null||student==null||book.getStudent()==null||book.getStudent().getStudentId()!=student.getStudentId()){
            throw new Exception("Unable to return the book");
        }


        List<Transaction> issuedTxns = transactionRepo.findByStudentAndBookAndTransactionTypeOrderByIdDesc(student, book, TransactionType.ISSUE);

        Transaction issueTnx = issuedTxns.get(0);

        long issueTimeInMs = issueTnx.getUpdatedOn().getTime();
        long currentTimeInMs = System.currentTimeMillis();

        long timeDiff = currentTimeInMs - issueTimeInMs;

        long diffInDays = TimeUnit.DAYS.convert(timeDiff,TimeUnit.MILLISECONDS);


        int fine = 0;
        if(diffInDays > fineAfterDays) {
            fine = (int) ((diffInDays - fineAfterDays) * finePerDay);

        }




        Transaction transaction=Transaction.builder()
        .book(book).transactionStatus(TransactionStatus.PENDING).student(student).transactionType(TransactionType.RETURN)
        .fine(fine).transactionId(UUID.randomUUID().toString())
        .build();
transactionRepo.save(transaction);
try{
    book.setStudent(null);
    bookServiceInterface.createBook(book);
    transaction.setTransactionStatus(TransactionStatus.SUCCESS);
    transactionRepo.save(transaction);
}
catch(Exception e){
    book.setStudent(student);
    bookServiceInterface.createBook(book);
    transaction.setTransactionStatus(TransactionStatus.FAILED);
    transaction.setTransactionType(TransactionType.ISSUE);
    transactionRepo.save(transaction);
        }
        return new ResponseEntity<>("Succes TransactionId -> "+transaction.getTransactionId(), HttpStatusCode.valueOf(200));
    }
}
