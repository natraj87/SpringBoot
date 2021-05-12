package com.example.rest.Springtest.Controller;

import com.example.rest.Springtest.repository.Libraryrep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestControllerclass {

    @Autowired
    Restcntrl restcntrl;
    @Autowired
    Libraryrep lib1;
    int count =0;

    @GetMapping("/greeting")
    public Restcntrl greeting(@RequestParam(value = "name") String name,@RequestParam (value = "name1")String name1)
    {
        count =count+1;
       restcntrl.setId(count);
       restcntrl.setName("The instructor name is "+name +name1);
       return restcntrl;
    }
   /* @PostMapping("/addbook")
    public void addbook(@RequestBody Library lib)
    {
         lib.setId(lib.getIsbn()+ lib.getAisle());
         lib1.save(lib);

    }*/




    
    
}
