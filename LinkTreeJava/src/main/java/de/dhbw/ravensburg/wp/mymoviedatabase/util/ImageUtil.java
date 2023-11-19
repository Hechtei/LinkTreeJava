package de.dhbw.ravensburg.wp.mymoviedatabase.util;

import de.dhbw.ravensburg.wp.mymoviedatabase.DTOs.InstaDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ImageUtil {

    public ImageUtil() {
    }

    public static BufferedImage loadImage(Path filePath) {
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

    public static byte[] imageToByteArray(BufferedImage image) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BufferedImage byteArrayToImage(byte[] bytes) {
        try {
            return ImageIO.read(new ByteArrayInputStream(bytes));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveImage(BufferedImage image, String filePath) {
        try {
            ImageIO.write(image, "png", new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<byte[]> allPicsToByte(List<InstaDTO> list){
        List<byte[]> output = new ArrayList<>();
        for(InstaDTO l : list){
            output.add(l.getPic());
        }
        return output;
    }

}
