package engine.physicsEngine.objects;

import engine.renderEngine.core.Drawer;
import engine.renderEngine.core.GameManager;
import engine.renderEngine.core.Window;

import java.util.ArrayList;

public class ObjectManager {

    private static ArrayList<GameObject> objects = new ArrayList<GameObject>();

    // Object methods
    public static void addObject(GameObject go) {
        objects.add(go);
    }

    public static void removeObject(GameObject go) {
        objects.remove(go);
    }

    public static void clearObjects() {
        objects.clear();
    }

    // Update methods
    public static void update(Window win, GameManager gm) {
        for (GameObject go : objects) {
            go.update(win, gm);
        }
    }

    public static void render(Window win, Drawer d) {
        for (GameObject go : objects) {
            go.render(win, d);
        }
    }

    public static ArrayList<GameObject> getObjects() {
        return objects;
    }

}
