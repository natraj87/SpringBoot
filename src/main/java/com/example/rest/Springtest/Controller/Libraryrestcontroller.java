package com.example.rest.Springtest.Controller;

import com.example.rest.Springtest.repository.Libraryrep;
import com.example.rest.Springtest.service.Libraryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class Libraryrestcontroller {

    @Autowired
    Libraryrep lib1;
    @Autowired
    addbookresponse ad;
    @Autowired
    Libraryservice serv;


    @PostMapping("/addbook")
    public ResponseEntity<addbookresponse> addbook(@RequestBody Library lib) {
        String id = lib.getIsbn() + lib.getAisle();


        //Old code
        //  Optional<Library> k =lib1.findById(id);
        // if(k.isPresent())
        //New one
        if (serv.checkbooklist(id)) {
            System.out.println("Book exist so working on sending error message");
            ad.setId(lib.getIsbn() + lib.getAisle());
            ad.setResp("Book is already present");
            return new ResponseEntity<addbookresponse>(ad, HttpStatus.ACCEPTED);
        } else {
            System.out.println("Book doe snot exist so can try adding book");
            lib.setId(id);
            lib1.save(lib);
            HttpHeaders h = new HttpHeaders();
            h.add("unique", id);
            ad.setId(lib.getIsbn() + lib.getAisle());
            ad.setResp("Book has been successfully added");
            return new ResponseEntity<addbookresponse>(ad, h, HttpStatus.CREATED);
        }

    }

    @GetMapping("/getbooks/{id}")
    public ResponseEntity<Library> getbooks(@PathVariable(value = "id") String id) {
        //if(serv.checkbooklist(id)) {
        try{
            Library recrd = lib1.findById(id).get();
            return new ResponseEntity<Library>(recrd, HttpStatus.ACCEPTED);
        }
       catch(Exception e)
       {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }


    }

    @GetMapping("/getbooks/author")
    public List<Library> getbooksbyauthour(@RequestParam(value = "authorname") String authorname)
    {
        System.out.println("the authour name is "+ authorname);
        return lib1.findAllbyauthorname(authorname);
    }

    @PostMapping("/updatebook/{id}")
    public ResponseEntity<Library> updatebook(@PathVariable(value = "id")String id, @RequestBody Library lib)
    {
        System.out.println(id);
       Library reslt = lib1.findById(id).get();
       System.out.println("The existing authour details are "+reslt.getAuthor());
       reslt.setAuthor(lib.getAuthor());
       System.out.println(reslt.getAuthor());
       reslt.setBook_name(lib.getBook_name());
        System.out.println(reslt.getBook_name());
       reslt.setAisle(lib.getAisle());
       System.out.println(reslt.getAisle());
//      String id1 = reslt.getIsbn() + lib.getAisle();
//      reslt.setId(id1);
//       System.out.println(reslt.getId());
//       try {
           lib1.save(reslt);
//       }
//       catch(Exception e)
//       {
//           System.out.println(e);
//       }
       return new ResponseEntity<Library>(reslt,HttpStatus.OK);
    }

    @DeleteMapping("/deletebook")
    public ResponseEntity<String> deletebookbyID(@RequestBody  Library lib)
    {
        Library deleterecrd = lib1.findById(lib.getId()).get();
        lib1.delete(deleterecrd);
        return new ResponseEntity<>("Book deleted",HttpStatus.CREATED);
    }

}



