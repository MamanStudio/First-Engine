package engine.physicsEngine.objects;

import engine.renderEngine.core.Drawer;
import engine.renderEngine.core.GameManager;
import engine.renderEngine.core.Window;
import engine.renderEngine.graphics.Image;

import java.awt.*;

public abstract class GameObject {

    /**
     * x - object x pos
     * y - object y pos
     * sx - object x scale
     * sy - object y scale
     */
    protected int x, y, sx, sy;

    /**
     * do draw - if the object should draw to the screen
     * did draw - if the object successfully draw to the screen
     * has image - if the object has image set to it
     */
    protected boolean doDraw=true, didDraw, hasImage, isDestroyed;

    /**
     * if the game object have an image this image will draw
     */
    protected Image image;

    /**
     * game object color
     */
    protected Color color = Color.WHITE;

    /**
     * game object tag
     */
    protected String tag;

    public void render(Window win, Drawer d) {
        if (doDraw) {
            if (hasImage) {
                d.drawImage(image, x, y);
            } else {
                d.fillRect(x, y, sx, sy, color);
            }
            didDraw = true;
        }
    }

    public abstract void update(Window win, GameManager gm);

    public int getX() { return x; }
    public int getY() { return y; }
    public int getSX() { return sx; }
    public int getSY() { return sy; }
    public boolean getDidDraw() { return didDraw; }

    public String getTag() {
        return tag;
    }

}
