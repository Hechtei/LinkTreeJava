package de.dhbw.ravensburg.wp.mymoviedatabase.controller;

import de.dhbw.ravensburg.wp.mymoviedatabase.service.LinkTreeService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface WebController {

    public String showForm();

    @GetMapping(value = {"/login"})
    public String showLogin();
    public String dashboard();

    public String postlogin();

}

