package game;

import javax.swing.JPanel;

import java.lang.Runnable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import mapgen.Map;
import entity.Player;
import game.KeyHandler;

public class Game extends JPanel implements Runnable
{
    private Thread gameThread;

    private boolean isRunning;
    private KeyHandler keyHandler = new KeyHandler();

    private static final int FPS = 60;

    // Game elements
    private Map map = new Map();
    private Player player = new Player(this.keyHandler);

    public static double deltaTime;

    public Game()
    {
        this.isRunning = true;

        // Add components
        this.addKeyListener(this.keyHandler);

        // Set up the screen
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
    }

    public void update()
    {
        this.player.update();
    }

    public void draw()
    {
        repaint();
    }

    public void startGameThread()
    {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    public void setIsRunning(boolean isRunning)
    {
        this.isRunning = isRunning;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        // Draw sprites and objects
        this.player.draw(g2D);

        g.dispose();
    }

    @Override
    public void run()
    {
        // Game Loop
        double drawInterval = 1e9 / FPS;
        deltaTime = 0;
        long lastTime = System.nanoTime();
        long currentTime = 0;

        long timer = 0;
        int drawCount = 0;

        while(this.gameThread != null && this.isRunning)
        {
            currentTime = System.nanoTime();

            deltaTime += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;

            lastTime = currentTime;
            
            if(deltaTime >= 1)
            {
                this.update();
                this.draw();

                deltaTime--;

                drawCount++;
            }

            // Debug: Draw FPS
            if(timer >= (long)1e9)
            {
                //System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
}
