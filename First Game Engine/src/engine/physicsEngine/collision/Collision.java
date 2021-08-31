package engine.physicsEngine.collision;

import engine.physicsEngine.objects.GameObject;

import java.awt.*;

public class Collision {

    public static boolean isColliding(GameObject go1, GameObject go2) {

        Rectangle r1 = new Rectangle(go1.getX(), go1.getY(), go1.getSX(), go1.getSY());
        Rectangle r2 = new Rectangle(go2.getX(), go2.getY(), go2.getSX(), go2.getSY());

        return r1.intersects(r2);
    }

}
