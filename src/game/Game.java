package game;

import javax.swing.JPanel;

import java.lang.Runnable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import mapgen.Map;
import entity.Player;
import entity.enemy.BigDemon;

public class Game extends JPanel implements Runnable
{
    private Thread gameThread;

    private boolean isRunning;

    //Player Key Handler
    private KeyHandler keyHandler = new KeyHandler();

    private static final int FPS = 60;

    // Game elements
    private Map map;
    private Player player = new Player(this.keyHandler);
    private BigDemon bigDemon = new BigDemon();

    public static double deltaTime;

    public Game()
    {
        this.isRunning = true;

        // Add components
        this.addKeyListener(this.keyHandler);
        this.map = new Map(this.player);

        // Set up the screen
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
    }

    // Update game elements: maps, player, entities, etc.
    public void update()
    {
        this.player.update();
        this.bigDemon.update();
    }

    // Redraw everything
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

    //Draw everything in here
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        // Draw sprites and objects
        this.map.draw(g2D);
        this.player.draw(g2D);
        this.bigDemon.draw(g2D);

        g.dispose();
    }

    @Override
    public void run()
    {
        double drawInterval = 1e9 / FPS; // 1s / FPS = means draw about 'FPS' times in 1 second
        deltaTime = 0;
        long lastTime = System.nanoTime(); // Get system time in nanoseconds
        long currentTime = 0;

        // debug information
        //long timer = 0;
        //int drawCount = 0;

        // Game Loop
        while(this.gameThread != null && this.isRunning)
        {
            currentTime = System.nanoTime();

            deltaTime += (currentTime - lastTime) / drawInterval;
            //timer += currentTime - lastTime;

            lastTime = currentTime;
            
            // if deltaTime hit 1 which means we finish the hold interval
            // so we reset deltaTime and then do everything again
            if(deltaTime >= 1) 
            {
                this.update();
                this.draw();

                // reset deltaTime back to 0
                deltaTime--;

                // debug information
                //drawCount++;
            }

            // Debug: Draw FPS
            //if(timer >= (long)1e9)
            //{
            //    System.out.println("FPS: " + drawCount);
            //    drawCount = 0;
            //    timer = 0;
            //}
        }
    }
}
