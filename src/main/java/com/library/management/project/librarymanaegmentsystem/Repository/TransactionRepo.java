package com.library.management.project.librarymanaegmentsystem.Repository;

import com.library.management.project.librarymanaegmentsystem.Model.Book;
import com.library.management.project.librarymanaegmentsystem.Model.Student;
import com.library.management.project.librarymanaegmentsystem.Model.Transaction;
import com.library.management.project.librarymanaegmentsystem.Model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Integer> {
    List<Transaction> findByStudentAndBookAndTransactionTypeOrderByIdDesc(Student student, Book book, TransactionType transactionType);
}
