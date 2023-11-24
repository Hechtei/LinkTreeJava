package de.dhbw.ravensburg.wp.mymoviedatabase;




import de.dhbw.ravensburg.wp.mymoviedatabase.model.InstaPic;


import de.dhbw.ravensburg.wp.mymoviedatabase.repository.InstaRepo;

import de.dhbw.ravensburg.wp.mymoviedatabase.service.LinkTreeService;

import de.dhbw.ravensburg.wp.mymoviedatabase.util.ImageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j

public class Tests {

    LinkTreeService linkTreeService;

    InstaRepo instaRepo;

    public Tests(LinkTreeService linkTreeService, InstaRepo instaRepo) {
        this.linkTreeService = linkTreeService;
        this.instaRepo = instaRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void callController(){



    }
}
