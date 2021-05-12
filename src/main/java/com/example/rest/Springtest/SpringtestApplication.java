package com.example.rest.Springtest;

import com.example.rest.Springtest.Controller.Library;
import com.example.rest.Springtest.repository.Libraryrep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.List;
import java.util.Optional;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
public class SpringtestApplication  {
	//implements CommandLineRunner

	@Autowired
	Libraryrep lib;
	public static void main(String[] args)
	{
		SpringApplication.run(SpringtestApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception
	{
     Library fin = lib.findById("fdsefr343").get();
     Library ent = new Library();
     ent.setAisle(25);
     ent.setId("natraj4825");
     ent.setAuthor("Natarajan");
     ent.setBook_name("Java");
     ent.setIsbn("natraj48");
		lib.save(ent);
		System.out.println(fin.getAisle());
		System.out.println(fin.getAuthor());
		List<Library> details= lib.findAll();
		for(Library d : details)
		{
          System.out.println(d.getAuthor());
		}

	}*/
}
