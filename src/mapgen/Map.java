package mapgen;

import assetloader.map.MapLoader;

import java.awt.Graphics2D;

import entity.Player;

public class Map 
{
    private MapLoader mapLoader = new MapLoader();

    public Map(Player p)
    {
        this.mapLoader.setPlayer(p);
    }

    // Draw the map on the screen
    public void draw(Graphics2D g)
    {
        this.mapLoader.draw(g);
    }
}
