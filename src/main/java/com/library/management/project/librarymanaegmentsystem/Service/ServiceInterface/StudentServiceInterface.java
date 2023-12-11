package com.library.management.project.librarymanaegmentsystem.Service.ServiceInterface;

import com.library.management.project.librarymanaegmentsystem.Model.Student;
import com.library.management.project.librarymanaegmentsystem.ModelWrapper.StudentWrapper;
import org.springframework.http.ResponseEntity;

public interface StudentServiceInterface {
    ResponseEntity<String> createStudent(Student student);

    ResponseEntity<Student> getStudentById(int studentId);
}
