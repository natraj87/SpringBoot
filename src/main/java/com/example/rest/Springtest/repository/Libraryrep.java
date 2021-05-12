package com.example.rest.Springtest.repository;

import com.example.rest.Springtest.Controller.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Libraryrep extends JpaRepository<Library,String>,LibraryrepCustom  {

}
