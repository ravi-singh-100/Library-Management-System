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
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private String bookName;
    @ManyToOne
    @JoinColumn(name = "authorId")
    @JsonIgnoreProperties(value={"updatedOn","createdOn"})
    private Author author;
    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties(value = "book")
    private List<Transaction> transactionList;
    @ManyToOne
    @JoinColumn(name = "studentId")
    @JsonIgnoreProperties(value = "bookList")
    private Student student;
    @Enumerated(value=EnumType.STRING)
    private Genre genre;
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;
}
