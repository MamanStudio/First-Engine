package engine.renderEngine.core;

import engine.physicsEngine.objects.ObjectManager;

import java.awt.*;
import java.util.ArrayList;

public class GameManager {

    private ArrayList<GameLevel> levels = new ArrayList<GameLevel>();
    private GameLevel currentLevel;
    private Window win;

    // GAME ACCESS
    public void addLevel(GameLevel level) {
        levels.add(level);
    }
    public void flushLevels(GameLevel level) {
        levels.clear();
    }
    public void enterLevel(int levelId, boolean doInit) {
        currentLevel = levels.get(levelId);
        if (doInit) {
            currentLevel.init(win, this);
        }
    }

    public Window createWindow(String title, int width, int height, int buffer_size) {
        win = new Window(title, width, height, buffer_size, this);
        return win;
    }

    // WINDOW ACCESS
    void init() {
        if (isLevelOpen())
            currentLevel.init(win, this);
    }
    void render() {
        if (isLevelOpen()) {
            win.clear(Color.BLACK);
            currentLevel.render(win, win.getDrawer(), this);
            ObjectManager.render(win, win.getDrawer());
            win.update();
            win.frames++;
        }
    }
    void update() {
        if (isLevelOpen()) {
            currentLevel.update(win, this);
            ObjectManager.update(win, this);
            win.ticks++;
        }
    }

    private boolean isLevelOpen() {
        return currentLevel != null;
    }

}
