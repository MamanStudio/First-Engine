package engine.renderEngine.graphics;

import engine.utils.Debug;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage img;
    private int sx, sy;

    public SpriteSheet(Image img, int sx, int sy) {
        this.img = img.getRawImage();
        this.sx = sx;
        this.sy = sy;
    }

    public BufferedImage getSpriteImage(int x, int y) {
        try {
            return img.getSubimage(x*sx, y*sy, sx, sy);
        } catch (Exception e) {
            Debug.LogError("SpriteSheet >> Failed to Acquire SubImage");
        }
        return null;
    }

    public Image getSprite(int arrayX, int arrayY) {
        return new Image(getSpriteImage(arrayX, arrayY));
    }

}
