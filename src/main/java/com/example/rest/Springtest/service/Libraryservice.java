package com.example.rest.Springtest.service;

import com.example.rest.Springtest.Controller.Library;
import com.example.rest.Springtest.repository.Libraryrep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Libraryservice {

    @Autowired
    Libraryrep lib1;
    public boolean checkbooklist(String id)
    {
        Optional<Library> k =lib1.findById(id);
        if(k.isPresent())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}


