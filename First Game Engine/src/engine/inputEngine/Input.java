package engine.inputEngine;

import engine.utils.Debug;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Input extends InputCodes implements KeyListener {

    private ArrayList<Integer> PressedKeys = new ArrayList<Integer>();
    private ArrayList<Integer> DownKeys = new ArrayList<Integer>();

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (DownKeys.indexOf(key) == -1) {
            PressedKeys.add(key);
            DownKeys.add(key);
            Debug.Log("Added key " + key);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (PressedKeys.indexOf(key) != -1)
            PressedKeys.remove(PressedKeys.indexOf(key));

        if (DownKeys.indexOf(key) != -1)
            DownKeys.remove(DownKeys.indexOf(key));

        Debug.Log("Removed key " + key);
    }

    // GAME ACCESS
    public boolean isKeyPressed(int key) {
        if (PressedKeys.indexOf(key) != -1) {
            PressedKeys.remove(PressedKeys.indexOf(key));
            return true;
        }
        return false;
    }

    public boolean isKeyDown(int key) {
        if (DownKeys.indexOf(key) != -1) {
            return true;
        }
        return false;
    }



    // UNUSED METHODS
    @Override
    public void keyTyped(KeyEvent e) { }
}
