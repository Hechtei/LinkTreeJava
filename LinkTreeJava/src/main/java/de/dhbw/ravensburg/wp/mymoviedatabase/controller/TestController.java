package de.dhbw.ravensburg.wp.mymoviedatabase.controller;

import de.dhbw.ravensburg.wp.mymoviedatabase.DTOs.InstaDTO;
import de.dhbw.ravensburg.wp.mymoviedatabase.service.LinkTreeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpHeaders;

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

    @GetMapping("/images")
    public ResponseEntity<List<ResponseEntity<byte[]>>> getImages() {
        List<InstaDTO> bilder = linkTreeService.getAllPic();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        // Erstellen Sie eine Liste von ResponseEntity-Objekten für jedes Bild
        List<ResponseEntity<byte[]>> responseEntities = bilder.stream()
                .map(bild -> new ResponseEntity<>(bild.getPic(), headers, HttpStatus.OK))
                .collect(Collectors.toList());

        return new ResponseEntity<>(responseEntities, HttpStatus.OK);
    }



}
