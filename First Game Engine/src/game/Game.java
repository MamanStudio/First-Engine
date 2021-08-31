package game;

import engine.inputEngine.Input;
import engine.inputEngine.Mouse;
import engine.physicsEngine.objects.ObjectManager;
import engine.renderEngine.core.Drawer;
import engine.renderEngine.core.GameLevel;
import engine.renderEngine.core.GameManager;
import engine.renderEngine.core.Window;
import engine.renderEngine.graphics.SpriteSheet;
import game.objects.Block;
import game.objects.Player;

public class Game extends GameLevel {

    SpriteSheet sp;
    int y = 20, x = 20;
    int cx, cy;
    Player player;
    Block block;

    String cords = "0, 0";

    public Game(int levelID) {
        this.levelID = levelID;
    }

    @Override
    public void init(Window win, GameManager gm) {

        int y = 32;
        player = new Player(32, y, 32, win);
        block = new Block(32, 120, 32, win);
        ObjectManager.addObject(player);
        ObjectManager.addObject(block);

    }

    @Override
    public void render(Window win, Drawer d, GameManager gm) {
//        d.drawString("Cords: " + cords, 100, 300);
//        b.render(win, d);
        d.setCameraPos(cx, cy);
    }

    @Override
    public void update(Window win, GameManager gm) {
        Input inp = win.getInput();
        Mouse m = win.getMouse();
        cords = m.getX() + ", " + m.getY();

        x = m.getX()-cx;
        y = m.getY()-cy;
    }

}
