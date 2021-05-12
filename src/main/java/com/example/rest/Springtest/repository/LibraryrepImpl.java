package com.example.rest.Springtest.repository;

import com.example.rest.Springtest.Controller.Library;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class LibraryrepImpl implements LibraryrepCustom {

   @Autowired
   Libraryrep librep;

   @Override
    public List<Library> findAllbyauthorname(String authorname) {
       System.out.println(authorname);
       List<Library> fullrecrds = librep.findAll();
       List<Library> partialrecrds = new ArrayList<Library>();
       for(Library item: fullrecrds)
       {
           if(item.getAuthor().equalsIgnoreCase(authorname))
           {
               System.out.println(item.getBook_name());
               partialrecrds.add(item);
           }
       }
       return partialrecrds;
    }
}
