package com.library.management.project.librarymanaegmentsystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;

    private String bookName;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;
    @OneToMany(mappedBy = "book")
    private List<Transaction> transaction;
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;
    @Enumerated(value=EnumType.STRING)
    private Genre genre;

    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;
}
