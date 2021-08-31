package engine.renderEngine.core;

import engine.inputEngine.Input;
import engine.inputEngine.Mouse;
import engine.utils.Debug;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Window extends Canvas {
    private static final long serialVersionUID = 1L;

    private static JFrame frame;
    private static int WIDTH, HEIGHT, BUFFER_SIZE;
    private static String TITLE;

    private GameManager gm;
    private Drawer drawer;

    private Input input = new Input();
    private Mouse mouse = new Mouse();

    int frames, ticks, time;
    private int lastFrames, lastTicks;

    private Thread loop;
    private final double UPDATE_SPEED = 60;
    private static boolean isRunning;

    public Window(String title, int width, int height, int bufferSize, GameManager gm) {

        this.gm = gm;

        Window.TITLE = title;
        Window.WIDTH = width;
        Window.HEIGHT = height;
        Window.BUFFER_SIZE = bufferSize;

        Dimension size = new Dimension(WIDTH, HEIGHT);
        setPreferredSize(size);
        setSize(size);
        setFocusable(true);


        frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(size);
        // adding the canvas to JFrame
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
        // centers the window
        frame.setLocationRelativeTo(null);

    }

    public void show() {
        this.createBufferStrategy(BUFFER_SIZE);
        isRunning = true;
        frame.setVisible(true);

        drawer = new Drawer(this);

        startInputListeners();
        gameLoop();
    }

    private void startInputListeners() {
        this.addKeyListener(input);
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
    }

    /**
     * Displays the next buffer
     */
    public void update() {
        if (!isRunning()) { Debug.LogError("WINDOW NOT INITIALIZED!"); }
        this.getBufferStrategy().show();
    }

    public void clear(Color ClearColor) {
        if (!isRunning()) { Debug.LogError("WINDOW NOT INITIALIZED!"); }
        BufferStrategy bs = this.getBufferStrategy();
        Graphics g = bs.getDrawGraphics();
        g.setColor(ClearColor);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void close() {
        Debug.Log("Window >> Window Is Closing");
        Debug.Log("Window >> Window Ran For " + time + ", Seconds");
        System.exit(0);
    }

    public void setFullScreen(boolean fullScreen) {
        if (fullScreen && !isRunning) {
            frame.dispose();
            frame.setUndecorated( true);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        }
        WIDTH = frame.getWidth(); HEIGHT = frame.getHeight();
    }

    private void gameLoop() {
        loop = new Thread() {
            public void run() {
                double lastTime = System.nanoTime();
                double delta = 0;
                final double ns = 1e9/UPDATE_SPEED;

                double start = System.currentTimeMillis();
                int next = 1;

                while (isRunning) {
                    double nowTime = System.nanoTime();
                    double now = (System.currentTimeMillis()-start)/1000;

                    delta += (nowTime - lastTime) / ns;
                    lastTime = nowTime;

                    while (delta >= 1) {
                        gm.update();
                        gm.render();
                        delta--;
                    }

                    if (now >= next) {
                        next++;
                        time++;
                        lastFrames = frames;
                        lastTicks = ticks;
                        Debug.Log("FPS: " + lastFrames + " UPS: " + lastTicks);
                        frames = 0;
                        ticks = 0;
                    }
                }

            }
        }; loop.start();
    }

    Drawer getDrawer() {
        return drawer;
    }

    public Input getInput() {
        return input;
    }

    public Mouse getMouse() {
        return mouse;
    }
}
