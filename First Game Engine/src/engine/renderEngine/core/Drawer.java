package engine.renderEngine.core;

import engine.renderEngine.graphics.Image;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Drawer {

    private BufferStrategy bs;
    private Graphics g;

    private int cameraX, cameraY;

    public Drawer(Window win) {
        this.bs = win.getBufferStrategy();
        this.g = bs.getDrawGraphics();
        g.setColor(Color.WHITE);
    }

    public void drawImage(Image img, int x, int y) {
        g.drawImage(img.getRawImage(), x, y, null);
    }

    public void drawString(String str, int x, int y) {
        g.drawString(str, x, y);
    }

    public void fillRect(int x, int y, int sx, int sy, Color color) {
        Color oldc = g.getColor();
        g.setColor(color);
        g.fillRect(x, y, sx, sy);
        g.setColor(oldc);
    }

    public void setColor(Color color) {
        g.setColor(color);
    }

    public void setCameraPos(int cx, int cy) {
        g.translate(-cameraX, -cameraY);
        cameraX = cx; cameraY = cy;
        g.translate(cameraX, cameraY);
    }

    public void moveCamera(int mx, int my) {
        cameraX += mx; cameraY += my;
        g.translate(mx, my);
    }

    public int getCX() {
        return cameraX;
    }

    public int getCY() {
        return cameraY;
    }

}
