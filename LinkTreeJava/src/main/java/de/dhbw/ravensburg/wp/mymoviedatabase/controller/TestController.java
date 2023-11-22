package de.dhbw.ravensburg.wp.mymoviedatabase.controller;

import de.dhbw.ravensburg.wp.mymoviedatabase.DTOs.InstaDTO;
import de.dhbw.ravensburg.wp.mymoviedatabase.service.LinkTreeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class TestController {

    LinkTreeService linkTreeService;

    public TestController(LinkTreeService linkTreeService) {
        this.linkTreeService = linkTreeService;
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {

        byte[] bild = linkTreeService.getPicById(id).getPic();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG); // Ändere den Medientyp entsprechend

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
    public String addPicture(@RequestParam String link, @RequestParam("bild")MultipartFile pic){

        if (!pic.isEmpty()) {
            try {
                byte[] bildBytes = pic.getBytes();

                // Bytes in ein BufferedImage umwandeln
                //ByteArrayInputStream inputStream = new ByteArrayInputStream(bildBytes);
                //BufferedImage bufferedImage = ImageIO.read(inputStream);
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



}
