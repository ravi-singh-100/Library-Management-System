package com.library.management.project.librarymanaegmentsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    @Column(length = 40)
    private String studentName;
    private  int age;
    @Email
    @Column(nullable = false,unique = true)
    private String email;
    @OneToMany(mappedBy ="student" )
    @JsonIgnoreProperties(value ={ "student","transactionList","createdOn","updatedOn"})
    private List<Book> bookList;
    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties(value = {"student","createdOn","updatedOn"})
    private List<Transaction> transactionList;
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;
}
