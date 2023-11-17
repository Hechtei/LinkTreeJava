package de.dhbw.ravensburg.wp.mymoviedatabase.service;


import de.dhbw.ravensburg.wp.mymoviedatabase.DTOs.InstaDTO;
import de.dhbw.ravensburg.wp.mymoviedatabase.model.InstaPic;

import java.util.List;

public interface LinkTreeService {

    List<InstaDTO> getAllPic();
    InstaDTO getPicById(Long id );

    void removePic(Long id );

    InstaDTO addPic(InstaDTO newPic);

    InstaDTO updatePic(InstaDTO updatedPic);

}

