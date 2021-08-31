package game;

import engine.renderEngine.core.GameManager;
import engine.renderEngine.core.Window;

public class Main extends GameManager {

    private static Window win;
    private static final int WIDTH = 1000, HEIGHT = 1000, BUFFER_SIZE = 2;
    private static final String TITLE = "Seruce Test";

    private static final int GAME_ID = 0;

    public Main() {
        win = createWindow(TITLE, WIDTH, HEIGHT, BUFFER_SIZE);
        win.setFullScreen(true);
        win.show();
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.addLevel(new Game(GAME_ID));
        m.enterLevel(GAME_ID, true);
    }

}
