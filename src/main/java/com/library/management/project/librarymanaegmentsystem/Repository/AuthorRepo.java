package com.library.management.project.librarymanaegmentsystem.Repository;

import com.library.management.project.librarymanaegmentsystem.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Integer> {
    @Query(value = "Select * from Author  where email = :email",nativeQuery = true)
    Author findByEmail(String email);
}
