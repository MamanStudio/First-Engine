package engine.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ResourceLoader {

    public static BufferedImage loadImage(String path) {
        try {
            BufferedImage img = ImageIO.read(new File(path));
            return img;
        } catch (Exception e) {
            Debug.Log("Error: " + e.getMessage());
        }

        return null;
    }

}
