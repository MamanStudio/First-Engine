package game.objects;

import engine.physicsEngine.objects.GameObject;
import engine.renderEngine.core.GameManager;
import engine.renderEngine.core.Window;

public class Block extends GameObject {

    public Block(int x, int y, int size, Window win) {
        this.x = x;
        this.y = y;
        this.sx = size;
        this.sy = size;

        this.tag = "block";
    }

    @Override
    public void update(Window win, GameManager gm) {

    }
}
