package assetloader.map;

import javax.imageio.ImageIO;

import window.GameWindow;

import mapgen.tile.tile_lists.FloorTile;
import mapgen.tile.tile_lists.WallTile;
import mapgen.tile.Tile;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import java.util.ArrayList;

import java.io.IOException;
import java.io.File;

import entity.Player;

public class MapLoader
{
    private LoadMapFromFile loadMapFromFile = new LoadMapFromFile();

    private FloorTile floorTile = new FloorTile();
    private WallTile wallTile = new WallTile();

    private Player player;

    // Screen settings
    public static final int MAX_SCREEN_COLUMNS = GameWindow.WINDOW_WIDTH / Tile.FINAL_TILE_SIZE;
    public static final int MAX_SCREEN_ROWS = GameWindow.WINDOW_HEIGHT / Tile.FINAL_TILE_SIZE;

    // World map settings
    public static final int MAX_WORLD_COLUMNS = LoadMapFromFile.WORLD_MAP_SIZE_COLUMNS;
    public static final int MAX_WORLD_ROWS = LoadMapFromFile.WORLD_MAP_SIZE_ROWS;
    public static final int WORLD_WIDTH = Tile.FINAL_TILE_SIZE * MAX_WORLD_COLUMNS;
    public static final int WORLD_HEIGHT = Tile.FINAL_TILE_SIZE * MAX_WORLD_ROWS;

    public MapLoader()
    {
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
                int worldX = j * Tile.FINAL_TILE_SIZE;
                int worldY = i * Tile.FINAL_TILE_SIZE;

                int screenX = worldX - this.player.getWorldXPosition() + this.player.getX();
                int screenY = worldY - this.player.getWorldYPosition() + this.player.getY();

                char tile = this.loadMapFromFile.getMap()[j][i];

                // Check to render only visible space
                if( worldX + Tile.FINAL_TILE_SIZE > this.player.getWorldXPosition() - this.player.getX() &&
                    worldX - 2 * Tile.FINAL_TILE_SIZE < this.player.getWorldXPosition() + this.player.getX() &&
                    worldY + Tile.FINAL_TILE_SIZE > this.player.getWorldYPosition() - this.player.getY() &&
                    worldY - Tile.FINAL_TILE_SIZE < this.player.getWorldYPosition() + this.player.getY())
                {
                    if(tile == 'W') this.wallTile.draw(g, screenX, screenY, this.wallTile.getAllWallTiles());
                    else if(tile == 'F') this.floorTile.draw(g, screenX, screenY, this.floorTile.getAllFloorTiles());
                }
            }
        }
    }

    public void setPlayer(Player p)
    {
        this.player = p;
    }
}
