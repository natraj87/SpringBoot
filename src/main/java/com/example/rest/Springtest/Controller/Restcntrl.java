package com.example.rest.Springtest.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Restcntrl {

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




}
