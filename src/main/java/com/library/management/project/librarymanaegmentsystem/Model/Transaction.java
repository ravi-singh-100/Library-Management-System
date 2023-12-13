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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String transactionId;
    @ManyToOne
    @JoinColumn(name = "bookId")
    @JsonIgnoreProperties(value = {"transactionList","student","createdOn","updatedOn","author"})
private Book book;
    @ManyToOne
    @JoinColumn(name = "studentId")
    @JsonIgnoreProperties(value = {"transactionList","createdOn","updatedOn"})
private Student student;
    private int fine;
@Enumerated(value = EnumType.STRING)
private TransactionStatus transactionStatus;
@Enumerated(value = EnumType.STRING)
private TransactionType transactionType;
@CreationTimestamp
    private Date createdOn;
@UpdateTimestamp
    private Date updatedOn;
}
