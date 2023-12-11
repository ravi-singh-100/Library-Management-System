package com.library.management.project.librarymanaegmentsystem.ModelWrapper;

import com.library.management.project.librarymanaegmentsystem.Model.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentWrapper {
    @NotBlank
    private String studentName;
    @NotBlank
    @Email
    private String email;
    @Positive
    private int age;
    public Student covertToStudent() {
        return Student.builder().studentName(studentName).age(age).email(email).build();
    }
}
