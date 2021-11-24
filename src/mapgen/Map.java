package mapgen;

import window.GameWindow;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;

public class Map 
{
    private static final int GRID_SIZE = 40;
    private static final int GAME_UNITS = (GameWindow.WINDOW_WIDTH * GameWindow.WINDOW_HEIGHT) / (GRID_SIZE * GRID_SIZE);

    public Map()
    {
    }

    public void drawDebugGuildlines(Graphics g)
    {
        g.setColor(Color.PINK);
        for(int i = 0; i < GameWindow.WINDOW_WIDTH / GRID_SIZE; i++)
        {
            for(int j = 0; j < GameWindow.WINDOW_HEIGHT / GRID_SIZE; j++)
            {
                g.drawLine(i * GRID_SIZE, 0, i * GRID_SIZE, GameWindow.WINDOW_HEIGHT);
                g.drawLine(0, i * GRID_SIZE, GameWindow.WINDOW_WIDTH, i * GRID_SIZE);
            }
        }
    }
}
