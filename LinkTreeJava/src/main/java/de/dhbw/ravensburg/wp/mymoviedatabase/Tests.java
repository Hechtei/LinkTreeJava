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

        InstaPic instaPic1 = new InstaPic("link");

        String absoultePath = "C:\\Users\\hecht\\OneDrive\\Desktop\\LinkTreeJava\\LinkTreeJava\\src\\main\\resources\\static\\instapics\\panda.png";

        BufferedImage image = ImageUtil.loadImage(Path.of(absoultePath));

        instaPic1.setPic(ImageUtil.imageToByteArray(image));

        instaRepo.save(instaPic1);

        InstaPic instaPic2 = new InstaPic("link");

        String absoultePath2 = "C:\\Users\\hecht\\OneDrive\\Desktop\\LinkTreeJava\\LinkTreeJava\\src\\main\\resources\\static\\instapics\\img.png";

        BufferedImage image2 = ImageUtil.loadImage(Path.of(absoultePath2));

        instaPic2.setPic(ImageUtil.imageToByteArray(image2));

        instaRepo.save(instaPic2);




    }
}
