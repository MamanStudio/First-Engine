package engine.inputEngine;

import engine.utils.Debug;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Mouse extends InputCodes implements MouseListener, MouseMotionListener {

    private static ArrayList<Integer> PressedButtons = new ArrayList<Integer>();
    private static ArrayList<Integer> DownButtons = new ArrayList<Integer>();

    private static int x, y;

    @Override
    public void mousePressed(MouseEvent e) {
        int button = e.getButton();

        if (DownButtons.indexOf(button)  == -1) {
            PressedButtons.add(button);
            DownButtons.add(button);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int button = e.getButton();
        if (PressedButtons.indexOf(button) != -1)
            PressedButtons.remove(PressedButtons.indexOf(button));

        if (DownButtons.indexOf(button) != -1)
            DownButtons.remove(DownButtons.indexOf(button));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    // GAME
    public boolean isButtonPressed(int button) {
        if (PressedButtons.indexOf(button) == -1) {
            PressedButtons.remove(PressedButtons.indexOf(button));
            return true;
        }
        return false;
    }

    public boolean isButtonDown(int button) {
        if (DownButtons.indexOf(button) != -1)
            return true;
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // UNUSED METHODS

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
