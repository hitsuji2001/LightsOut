package assetloader;

import java.util.ArrayList;

import java.awt.image.BufferedImage;

import java.io.IOException;

public class MovingSpriteHandler
{
    private ArrayList <String> spriteFileNameUp = new ArrayList<>();
    private ArrayList <String> spriteFileNameDown = new ArrayList<>();
    private ArrayList <String> spriteFileNameLeft = new ArrayList<>();
    private ArrayList <String> spriteFileNameRight = new ArrayList<>();

    private ArrayList <BufferedImage> spriteUp = new ArrayList<>();
    private ArrayList <BufferedImage> spriteDown = new ArrayList<>();
    private ArrayList <BufferedImage> spriteLeft = new ArrayList<>();
    private ArrayList <BufferedImage> spriteRight = new ArrayList<>();

    private SpriteLoader spriteLoader;
    
    public MovingSpriteHandler(ArrayList<String> up, ArrayList<String> down, ArrayList<String> left, ArrayList<String> right)
    {
        this.setUp(up, down, left, right);
    }

    public MovingSpriteHandler()
    {
    }

    public void setUp(ArrayList<String> up, ArrayList<String> down, ArrayList<String> left, ArrayList<String> right)
    {
        this.loadSpriteFile(up, down, left, right);
        try
        {
            this.loadSprite();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void loadSpriteFile(ArrayList<String> up, ArrayList<String> down, ArrayList<String> left, ArrayList<String> right)
    {
        this.spriteFileNameUp = up;
        this.spriteFileNameDown = down;
        this.spriteFileNameLeft = left;
        this.spriteFileNameRight = right;
    }
    
    public void loadSprite() throws IOException
    {
        this.spriteLoader.loadImages();
    }

    public ArrayList <BufferedImage> getSpriteUp()
    {
        return this.spriteUp;
    }

    public ArrayList <BufferedImage> getSpriteDown()
    {
        return this.spriteDown;
    }

    public ArrayList <BufferedImage> getSpriteLeft()
    {
        return this.spriteLeft;
    }

    public ArrayList <BufferedImage> getSpriteRight()
    {
        return this.spriteRight;
    }
}
