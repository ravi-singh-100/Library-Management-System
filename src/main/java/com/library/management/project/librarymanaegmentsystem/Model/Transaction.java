package com.library.management.project.librarymanaegmentsystem.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;
    @ManyToOne
    @JoinColumn(name = "bookId")
private Book book;
    @ManyToOne
    @JoinColumn(name = "studentId")
private Student student;
    private Integer fine;
@Enumerated(value = EnumType.ORDINAL)
private TransactionStatus transactionStatus;
@Enumerated(value = EnumType.ORDINAL)
private TransactionType transactionType;
@CreationTimestamp
    private Date createOn;
@UpdateTimestamp
    private Date updatedOn;
}
