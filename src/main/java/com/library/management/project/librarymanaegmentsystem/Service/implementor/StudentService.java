package com.library.management.project.librarymanaegmentsystem.Service.implementor;

import com.library.management.project.librarymanaegmentsystem.Model.Student;
import com.library.management.project.librarymanaegmentsystem.Repository.StudentRepo;
import com.library.management.project.librarymanaegmentsystem.Service.ServiceInterface.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService implements StudentServiceInterface {
    @Autowired
    StudentRepo studentRepo;
    @Override
    public ResponseEntity<String> createStudent(Student student) {
       studentRepo.save(student);
       return new ResponseEntity<>("Succes", HttpStatusCode.valueOf(201));
    }

    @Override
    public Student getStudentById(int studentId) {
      Student student= studentRepo.findById(studentId).orElse(null);
//      return new ResponseEntity<>(student,HttpStatusCode.valueOf(200));
        return student;
    }


    @Override
    public ResponseEntity<List<Student>> getAllStudent() {
        return new ResponseEntity<>(studentRepo.findAll(),HttpStatusCode.valueOf(200));
    }

}
