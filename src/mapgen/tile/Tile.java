package mapgen.tile;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Tile
{
    private boolean isSolid;
    private boolean canHurtPlayer;
    private int damageDealt = 0;
    private BufferedImage image;
    private Random random = new Random();

    public static final int TILE_SIZE = 16;
    public static final int TILE_SCALER = 2;
    public static final int FINAL_TILE_SIZE = TILE_SIZE * TILE_SCALER;

    public Tile()
    {
    }

    public void loadTilesFromFiles(String folderPath, ArrayList <Tile> array, Tile tile) throws IOException
    {
        File folder = new File(folderPath);

        for(File f : folder.listFiles())
        {
            tile.setImage(ImageIO.read(f));
            array.add(tile);
        }
    }

    public void draw(Graphics2D g, int x, int y, ArrayList <Tile> tileLists)
    {
        g.drawImage(tileLists.get(this.random.nextInt(tileLists.size())).getImage(), x, y, Tile.FINAL_TILE_SIZE, Tile.FINAL_TILE_SIZE, null);
    }

    public Tile(BufferedImage image, boolean isSolid)
    {
        this.isSolid = isSolid;
        this.image = image;
    }

    public BufferedImage getImage()
    {
        return this.image;
    }

    public void setImage(BufferedImage image)
    {
        this.image = image;
    }

    public boolean canHurtPlayer()
    {
        return this.canHurtPlayer;
    }
    
    public void setCanHurtPlayer(boolean bool)
    {
        this.canHurtPlayer = bool;
    }

    public int getDamageDealth()
    {
        return this.damageDealt;
    }

    public void setDamageDealth(int damageDealt)
    {
        this.damageDealt = damageDealt;
    }

    public boolean getIsSolid()
    {
        return this.isSolid;
    }

    public void setIsSolid(boolean isSolid)
    {
        this.isSolid = isSolid;
    }
}
