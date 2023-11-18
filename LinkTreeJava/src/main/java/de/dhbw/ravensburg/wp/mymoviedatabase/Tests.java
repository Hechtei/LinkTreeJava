package de.dhbw.ravensburg.wp.mymoviedatabase;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@Slf4j
public class Tests {
    @EventListener(ApplicationReadyEvent.class)
    public void callController() {

        log.info("kekW");

        String relativePathString = "LinkTreeJava/src/main/resources/static/pics/FacebookIcon.png";

        Path relativePath = Paths.get(relativePathString);

        Path absolutePath = relativePath.toAbsolutePath();

        log.info(absolutePath.toString());

        BufferedImage image = loadImage(absolutePath);

        byte[] imageBytes = imageToByteArray(image);

        BufferedImage restoredImage = byteArrayToImage(imageBytes);

        saveImage(restoredImage, "C:\\Users\\hecht\\OneDrive\\Desktop\\LinkTreeJava\\LinkTreeJava\\src\\main\\resources\\static\\pics\\TestPic.jpg");
    }

    private static BufferedImage loadImage(Path filePath) {
        try {
            log.info("Versuche, Bild zu laden: {}", filePath);
            File file = new File(filePath.toString());
            if (!file.exists()) {
                log.error("Die Datei existiert nicht: {}", filePath);
                return null;
            }
            return ImageIO.read(file);
        } catch (IOException e) {
            log.error("Fehler beim Lesen der Bilddatei: {}", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] imageToByteArray(BufferedImage image) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static BufferedImage byteArrayToImage(byte[] bytes) {
        try {
            return ImageIO.read(new ByteArrayInputStream(bytes));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void saveImage(BufferedImage image, String filePath) {
        try {
            ImageIO.write(image, "png", new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
