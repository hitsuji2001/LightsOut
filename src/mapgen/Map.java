package mapgen;

import assetloader.MapLoader;
import window.GameWindow;

import javax.swing.JPanel;

import java.awt.Graphics2D;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Map 
{
    private JPanel gamePanel;
    private MapLoader normalFloorTiles = new MapLoader();
    private MapLoader wallTiles = new MapLoader();
    
    public static final int TILE_SIZE = 16;
    public static final int TILE_SCALER = 2;
    public static final int FINAL_TILE_SIZE = TILE_SIZE * TILE_SCALER;

    public Map(JPanel gamePanel)
    {
        this.gamePanel = gamePanel;

        try
        {
            this.loadFile();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g)
    {
        int temp = 0;
        for(int i = 0; i < GameWindow.WINDOW_WIDTH; i += FINAL_TILE_SIZE)
        {
            for(int j = 0; j < GameWindow.WINDOW_HEIGHT; j += FINAL_TILE_SIZE)
            {
                temp++;
                g.drawImage(this.normalFloorTiles.getTileMap().get(temp % 8), i, j, FINAL_TILE_SIZE, FINAL_TILE_SIZE, null);
            }
        }
    }

    private void loadFile() throws IOException
    {
        this.loadFloorTiles();
        this.loadWallTiles();

        this.normalFloorTiles.loadImageFromFilePath();
        this.wallTiles.loadImageFromFilePath();
    }

    private void loadFloorTiles() throws FileNotFoundException
    {
        String floorFolder = "assets/map/floor";

        this.normalFloorTiles.loadFilesFromFolder(floorFolder);
    }

    private void loadWallTiles() throws FileNotFoundException
    {
        String wallFolder = "assets/map/wall";

        this.wallTiles.loadFilesFromFolder(wallFolder);
    }
}
