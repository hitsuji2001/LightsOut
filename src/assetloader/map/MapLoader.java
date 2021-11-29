package assetloader.map;

import javax.imageio.ImageIO;

import window.GameWindow;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import java.util.ArrayList;

import java.io.IOException;
import java.io.File;

import entity.Player;

public class MapLoader
{
    private ArrayList <BufferedImage> normalTiles = new ArrayList<>();
    private ArrayList <BufferedImage> wallTiles = new ArrayList<>();
    private ArrayList <BufferedImage> spikeTiles = new ArrayList<>();
    private ArrayList <BufferedImage> allTiles = new ArrayList<>();

    private LoadMapFromFile loadMapFromFile = new LoadMapFromFile();

    private Player player;

    // Screen settings
    public static final int TILE_SIZE = 16;
    public static final int TILE_SCALER = 2;
    public static final int FINAL_TILE_SIZE = TILE_SIZE * TILE_SCALER;

    public static final int MAX_SCREEN_COLUMNS = GameWindow.WINDOW_WIDTH / FINAL_TILE_SIZE;
    public static final int MAX_SCREEN_ROWS = GameWindow.WINDOW_HEIGHT / FINAL_TILE_SIZE;

    // World map settings
    public static final int MAX_WORLD_COLUMNS = LoadMapFromFile.WORLD_MAP_SIZE_COLUMNS;
    public static final int MAX_WORLD_ROWS = LoadMapFromFile.WORLD_MAP_SIZE_ROWS;
    public static final int WORLD_WIDTH = FINAL_TILE_SIZE * MAX_WORLD_COLUMNS;
    public static final int WORLD_HEIGHT = FINAL_TILE_SIZE * MAX_WORLD_ROWS;

    String floorFilePaths;
    String wallFilePaths;
    String spikeFilePaths;

    public MapLoader(String floorFilePath, String wallFilePaths, String spikeFilePaths)
    {
        this.floorFilePaths = floorFilePath;
        this.wallFilePaths = wallFilePaths;
        this.spikeFilePaths = spikeFilePaths;

        try
        {
            this.setUp();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public MapLoader()
    {
    }

    public void setUp() throws IOException
    {
        File floor = new File(this.floorFilePaths);
        File wall = new File(this.wallFilePaths);
        File spike = new File(this.spikeFilePaths);

        for(File f : floor.listFiles()) this.normalTiles.add(ImageIO.read(f));
        for(File f : wall.listFiles()) this.wallTiles.add(ImageIO.read(f));
        for(File f : spike.listFiles()) this.spikeTiles.add(ImageIO.read(f));
        
        this.addAlltiles();
    }

    private void addAlltiles()
    {
        this.allTiles.addAll(this.normalTiles);
        this.allTiles.addAll(this.wallTiles);
        this.allTiles.addAll(this.spikeTiles);
    }

    public void initialize(String floorFilePath, String wallFilePaths, String spikeFilePaths) throws IOException
    {
        this.setWallFilePath(wallFilePaths);
        this.setFloorFilePath(floorFilePath);
        this.setSpikeFilePath(spikeFilePaths);

        this.setUp();
    }

    public void draw(Graphics2D g)
    {
        //this.drawAllTiles(g);
        
        // Camera System
        // Basicly draw the map around the player
        for(int i = 0; i < MAX_WORLD_ROWS; i++)
        {
            for(int j = 0; j < MAX_WORLD_COLUMNS; j++)
            {
                int worldX = j * FINAL_TILE_SIZE;
                int worldY = i * FINAL_TILE_SIZE;

                int screenX = worldX - this.player.getWorldXPosition() + this.player.getX();
                int screenY = worldY - this.player.getWorldYPosition() + this.player.getY();

                int tile = this.loadMapFromFile.getMap()[j][i];

                // Check to render only visible space
                if( worldX + FINAL_TILE_SIZE > this.player.getWorldXPosition() - this.player.getX() &&
                    worldX - 2 * FINAL_TILE_SIZE < this.player.getWorldXPosition() + this.player.getX() &&
                    worldY + FINAL_TILE_SIZE > this.player.getWorldYPosition() - this.player.getY() &&
                    worldY - FINAL_TILE_SIZE < this.player.getWorldYPosition() + this.player.getY())
                {
                    g.drawImage(this.allTiles.get(tile), screenX, screenY, FINAL_TILE_SIZE, FINAL_TILE_SIZE, null);
                }
            }
        }
    }

    public void drawAllTiles(Graphics2D g)
    {
        int temp = 0;

        for(int i = 0; i < GameWindow.WINDOW_WIDTH; i += FINAL_TILE_SIZE)
        {
            for(int j = 0; j < GameWindow.WINDOW_HEIGHT; j += FINAL_TILE_SIZE)
            {
                if(temp >= this.allTiles.size()) break;
                g.drawImage(this.allTiles.get(temp), j, i, FINAL_TILE_SIZE, FINAL_TILE_SIZE, null);
                temp++;
            }
        }
    }

    public void setFloorFilePath(String path)
    {
        this.floorFilePaths = path;
    }

    public void setWallFilePath(String path)
    {
        this.wallFilePaths = path;
    }

    public void setSpikeFilePath(String path)
    {
        this.spikeFilePaths = path;
    }

    public void setPlayer(Player p)
    {
        this.player = p;
    }
}
