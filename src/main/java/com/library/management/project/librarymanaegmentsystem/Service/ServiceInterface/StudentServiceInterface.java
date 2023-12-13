package com.library.management.project.librarymanaegmentsystem.Service.ServiceInterface;

import com.library.management.project.librarymanaegmentsystem.Model.Student;
import com.library.management.project.librarymanaegmentsystem.ModelWrapper.StudentWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentServiceInterface {
    ResponseEntity<String> createStudent(Student student);

    Student getStudentById(int studentId);

    ResponseEntity<List<Student>> getAllStudent();
}
