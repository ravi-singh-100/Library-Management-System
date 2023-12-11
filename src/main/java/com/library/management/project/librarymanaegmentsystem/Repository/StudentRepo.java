package com.library.management.project.librarymanaegmentsystem.Repository;

import com.library.management.project.librarymanaegmentsystem.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
