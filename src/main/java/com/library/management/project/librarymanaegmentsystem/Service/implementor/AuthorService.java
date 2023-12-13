package com.library.management.project.librarymanaegmentsystem.Service.implementor;

import com.library.management.project.librarymanaegmentsystem.Model.Author;
import com.library.management.project.librarymanaegmentsystem.Repository.AuthorRepo;
import com.library.management.project.librarymanaegmentsystem.Service.ServiceInterface.AuthorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService implements AuthorServiceInterface {
    @Autowired
    AuthorRepo
    authorRepo;
    public Author getOrCreateAuthor(Author author){
       Author auth= authorRepo.findByEmail(author.getEmail());
       if(auth==null){
           auth=authorRepo.save(author);
       }
       return auth;
    }
}
