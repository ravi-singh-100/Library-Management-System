package com.library.management.project.librarymanaegmentsystem.ModelWrapper;

import com.library.management.project.librarymanaegmentsystem.Model.Author;
import com.library.management.project.librarymanaegmentsystem.Model.Book;
import com.library.management.project.librarymanaegmentsystem.Model.Genre;
import com.library.management.project.librarymanaegmentsystem.Model.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookWrapper {
    @NotBlank
    private String bookName;
    @NotNull
    private Genre genre;
    @NotBlank
    private  String authorName;
    @NotNull
    @Email
    private String authorEmail;

 public Book bookWrapperToBook(){
     Author auth=Author.builder().authorName(authorName).email(authorEmail).build();
System.out.println("*********** >"+auth.getEmail());
     return Book.builder().genre(genre).bookName(bookName).author(auth).build();
 }
}
