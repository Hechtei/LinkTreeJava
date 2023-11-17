package de.dhbw.ravensburg.wp.mymoviedatabase.controller;


import de.dhbw.ravensburg.wp.mymoviedatabase.DTOs.InstaDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface InstaController {

        List<InstaDTO> getAllPictures();
        InstaDTO getPictureById(Long id);

        InstaDTO updatePicture(InstaDTO instaDTO, Long id);

        InstaDTO addPicture(InstaDTO instaDTO);

        void deletePicture(Long id);

}




