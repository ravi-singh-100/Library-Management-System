package com.library.management.project.librarymanaegmentsystem.Controller;

import com.library.management.project.librarymanaegmentsystem.Model.Student;
import com.library.management.project.librarymanaegmentsystem.ModelWrapper.StudentWrapper;
import com.library.management.project.librarymanaegmentsystem.Service.ServiceInterface.StudentServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServiceInterface studentServiceInterface;
    @PostMapping("/createStudent")
    public ResponseEntity<String> createStudent(@Valid @RequestBody StudentWrapper studentWrapper){
        return  studentServiceInterface.createStudent(studentWrapper.covertToStudent());
    }
    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int studentId){
        return studentServiceInterface.getStudentById(studentId);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Student>>getAllStudent(){
        return studentServiceInterface.getAllStudent();
    }
}
