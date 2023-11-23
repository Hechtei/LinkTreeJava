package de.dhbw.ravensburg.wp.mymoviedatabase.controller;// WebControllerImpl.java

import de.dhbw.ravensburg.wp.mymoviedatabase.DTOs.InstaDTO;
import de.dhbw.ravensburg.wp.mymoviedatabase.service.LinkTreeService;
import de.dhbw.ravensburg.wp.mymoviedatabase.util.ImageUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class WebControllerImpl implements WebController {

    LinkTreeService linkTreeService;


    WebControllerImpl(LinkTreeService linkTreeService) {
        this.linkTreeService = linkTreeService;
    }

    @Override
    public String showForm(Model model) {
        return null;
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        byte[] bild = linkTreeService.getPicById(id).getPic();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(bild, headers, HttpStatus.OK);
    }

    @GetMapping("/")
    public ModelAndView getImages() {

        List<InstaDTO> pics = this.linkTreeService.getAllPic();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("data", pics);
        return modelAndView;
    }

    @PostMapping("/speichern")
    public String addPicture(@RequestParam String link, @RequestParam("bild") MultipartFile pic) {

        if (!pic.isEmpty()) {
            try {
                byte[] bildBytes = pic.getBytes();

                InstaDTO instaDTO = new InstaDTO();
                instaDTO.setPic(bildBytes);
                instaDTO.setLink(link);

                linkTreeService.addPic(instaDTO);

            } catch (IOException e) {
                e.printStackTrace(); // Handle die Ausnahme entsprechend
            }
        }
        return "redirect:/dashboard";
    }

    @GetMapping(value = {"/login"})
    public String showLogin() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @PostMapping(value = {"/login"})
    public String postlogin() {
        return "redirect:/dashboard";
    }

}
