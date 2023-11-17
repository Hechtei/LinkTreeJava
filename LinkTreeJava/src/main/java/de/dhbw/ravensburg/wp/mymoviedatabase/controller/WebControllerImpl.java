package de.dhbw.ravensburg.wp.mymoviedatabase.controller;// WebControllerImpl.java
import de.dhbw.ravensburg.wp.mymoviedatabase.service.LinkTreeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebControllerImpl implements WebController{

    LinkTreeService linkTreeService;

    WebControllerImpl(LinkTreeService linkTreeService){
        this.linkTreeService = linkTreeService;
    }

    @GetMapping(value = {"/","index.html"})
    public String showForm() {
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
