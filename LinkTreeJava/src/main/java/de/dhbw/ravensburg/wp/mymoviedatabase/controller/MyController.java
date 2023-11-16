package de.dhbw.ravensburg.wp.mymoviedatabase.controller;// MyController.java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @GetMapping(value = {"/","index.html"})
    public String showForm(Model model) {
        return "index";
    }
    @GetMapping(value = {"/login"})
    public String showLogin(){
        return "login";
    }
    @GetMapping("/dashboard")
    public String dashboard(){
        return  "dashboard";
    }

    @PostMapping(value = {"/login"})
    public String postlogin(){
        return "redirect:/dashboard";
    }

}
