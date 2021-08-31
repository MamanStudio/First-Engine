package engine.renderEngine.graphics;

import engine.utils.ResourceLoader;

import java.awt.image.BufferedImage;

public class Image {

    private BufferedImage img;

    public Image(String path) {
        img = ResourceLoader.loadImage(path);
    }

    public Image(BufferedImage img) {
        this.img = img;
    }

    public BufferedImage getRawImage() {
        return img;
    }

    public int getWith() {
        return img.getWidth(null);
    }

    public int getHeight() {
        return img.getHeight(null);
    }
}
