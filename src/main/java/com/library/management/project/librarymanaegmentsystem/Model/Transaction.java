package com.library.management.project.librarymanaegmentsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;
    @ManyToOne
    @JoinColumn(name = "bookId")
    @JsonIgnoreProperties(value = "transactionList")
private Book book;
    @ManyToOne
    @JoinColumn(name = "studentId")
    @JsonIgnoreProperties(value = "transactionList")
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
