package de.dhbw.ravensburg.wp.mymoviedatabase.controller;


import de.dhbw.ravensburg.wp.mymoviedatabase.DTOs.InstaDTO;
import de.dhbw.ravensburg.wp.mymoviedatabase.service.LinkTreeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pics")
public class InstaControllerImpl implements InstaController {


    LinkTreeService linkTreeService;

    InstaControllerImpl(LinkTreeService linkTreeService) {

        this.linkTreeService = linkTreeService;
    }


    @Override
    @GetMapping("/")
    public List<InstaDTO> getAllPictures() {
        return linkTreeService.getAllPic();
    }

    @Override
    public InstaDTO getPictureById(Long id) {
        return null;
    }


    @GetMapping(value = "/{id}")
   public ResponseEntity<byte[]> getProduktBild(@PathVariable Long id){

        byte[] bild = linkTreeService.getPicById(id).getPic();

       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.IMAGE_PNG);

       return new ResponseEntity<>(bild, headers, HttpStatus.OK);
   }

    public byte[] showPictureById(@PathVariable("id")Long id ){
        return linkTreeService.getPicById(id).getPic();
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
