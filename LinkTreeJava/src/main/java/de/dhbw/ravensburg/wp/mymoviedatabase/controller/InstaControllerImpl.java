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
@RequestMapping(value = "{/images}")
public class InstaControllerImpl implements InstaController {
    LinkTreeService linkTreeService;
    InstaControllerImpl(LinkTreeService linkTreeService) {

        this.linkTreeService = linkTreeService;
    }

}