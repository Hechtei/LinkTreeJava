package de.dhbw.ravensburg.wp.mymoviedatabase.controller;


import de.dhbw.ravensburg.wp.mymoviedatabase.DTOs.InstaDTO;
import de.dhbw.ravensburg.wp.mymoviedatabase.service.LinkTreeService;
import de.dhbw.ravensburg.wp.mymoviedatabase.util.ImageUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.util.List;

@Controller

public class InstaControllerImpl implements InstaController {


    LinkTreeService linkTreeService;

    InstaControllerImpl(LinkTreeService linkTreeService) {

        this.linkTreeService = linkTreeService;
    }


    @Override

    public List<InstaDTO> getAllPictures() {
        return linkTreeService.getAllPic();
    }

    @Override
    public InstaDTO getPictureById(Long id) {
        return null;
    }


    @GetMapping(value = "/pics")
   public String  getImage(Model model){
        byte[] bild = linkTreeService.getPicById(1L).getPic();
        model.addAttribute("bild",bild);
        return "dashboard";
   }







    @Override
    @PutMapping(value = "{/id}")
    public InstaDTO updatePicture(@RequestBody InstaDTO instaDTO, @PathVariable("id") Long id) {
        instaDTO.setId(id);
        return linkTreeService.updatePic(instaDTO);

    }

    @Override
    @PostMapping("/")
    public InstaDTO addPicture(@RequestBody InstaDTO instaDTO) {
        return linkTreeService.addPic(instaDTO);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deletePicture(@PathVariable Long id) {
        linkTreeService.removePic(id);
    }
}
