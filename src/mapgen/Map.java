package mapgen;

import assetloader.map.MapLoader;

import java.awt.Graphics2D;

import java.io.IOException;

import entity.Player;

public class Map 
{
    private MapLoader mapLoader = new MapLoader();

    public Map(Player p)
    {
        try
        {
            String floor = "assets/map/floor/normalfloor/";
            String wall = "assets/map/wall/nonanimated/";
            String spike = "assets/map/floor/spike/";
            this.mapLoader.initialize(floor, wall, spike);

            this.mapLoader.setPlayer(p);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    // Draw the map on the screen
    public void draw(Graphics2D g)
    {
        this.mapLoader.draw(g);
    }
}
