package game.objects;

import engine.inputEngine.Input;
import engine.inputEngine.InputCodes;
import engine.physicsEngine.collision.Collision;
import engine.physicsEngine.objects.GameObject;
import engine.physicsEngine.objects.ObjectManager;
import engine.renderEngine.core.GameManager;
import engine.renderEngine.core.Window;
import engine.renderEngine.graphics.Image;
import engine.utils.Debug;
import game.Game;

import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y, int size, Window win) {;
        this.x = x;;
        this.y = y;;
        this.sx = size;;
        this.sy = size;;
        //this.image = new Image("../res/Photos-icon.png");;
        //this.hasImage = true;
        this.color = Color.CYAN;

        this.tag = "player";
    }

    @Override
    public void update(Window win, GameManager gm) {
        Input inp = win.getInput();
        if (inp.isKeyDown(InputCodes.KEY_W) || inp.isKeyDown(InputCodes.UP_ARROW)) {
            this.y -= 1;
        }

       if (inp.isKeyDown(InputCodes.KEY_S) || inp.isKeyDown(InputCodes.DOWN_ARROW)) {
           this.y += 1;
       }

       if (inp.isKeyDown(InputCodes.KEY_A) || inp.isKeyDown(InputCodes.LEFT_ARROW)) {
           this.x -= 1;
       }

        if (inp.isKeyDown(InputCodes.KEY_D) || inp.isKeyDown(InputCodes.RIGHT_ARROW)) {
            this.x += 1;
        }

        checkCollision();
    }

    private void checkCollision() {
        for (int i = 0; i < ObjectManager.getObjects().size();i++) {
            GameObject go = ObjectManager.getObjects().get(i);
            if (go.getTag().equals("block")) {
                if (Collision.isColliding(this, go)) {
                    Debug.Log("I have friends");
                }
            }
        }
    }
}
