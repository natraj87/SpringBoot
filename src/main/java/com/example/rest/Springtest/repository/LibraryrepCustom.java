package com.example.rest.Springtest.repository;

import com.example.rest.Springtest.Controller.Library;

import java.util.List;

public interface LibraryrepCustom {

    List<Library> findAllbyauthorname(String authorname);
}
