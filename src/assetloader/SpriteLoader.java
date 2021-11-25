package assetloader;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.util.ArrayList;

import java.io.IOException;
import java.io.File;

public class SpriteLoader
{
    public ArrayList <BufferedImage> upSprites = new ArrayList<>();
    public ArrayList <BufferedImage> downSprites = new ArrayList<>();
    public ArrayList <BufferedImage> leftSprites = new ArrayList<>();
    public ArrayList <BufferedImage> rightSprites = new ArrayList<>();

    public ArrayList <String> upFiles = new ArrayList<>();
    public ArrayList <String> downFiles = new ArrayList<>();
    public ArrayList <String> leftFiles = new ArrayList<>();
    public ArrayList <String> rightFiles = new ArrayList<>();

    public SpriteLoader(ArrayList <String> upFiles, ArrayList <String> downFiles, ArrayList <String> leftFiles, ArrayList <String> rightFiles)
    {
        this.upFiles = upFiles;
        this.downFiles = downFiles;
        this.leftFiles = leftFiles;
        this.rightFiles = rightFiles;
    }

    public void loadImages() throws IOException
    {
        this.loadImagesInOneDirection(upSprites, upFiles);
        this.loadImagesInOneDirection(downSprites, downFiles);
        this.loadImagesInOneDirection(leftSprites, leftFiles);
        this.loadImagesInOneDirection(rightSprites, rightFiles);
    }

    public void loadImagesInOneDirection(ArrayList <BufferedImage> sprite, ArrayList <String> files) throws IOException
    {
        if(!files.isEmpty())
        {
            for(int i = 0; i < files.size(); i++)
            {
                File file = new File(files.get(i));
                sprite.add(ImageIO.read(file));
            }
        }
    }

    public static void loadFiles(ArrayList <String> files, ArrayList<BufferedImage> sprite) throws IOException
    {
        if(!files.isEmpty())
        {
            for(int i = 0; i < files.size(); i++)
            {
                File file = new File(files.get(i));
                sprite.add(ImageIO.read(file));
            }
        }
    }

    public ArrayList <BufferedImage> getSpriteUp()
    {
        return this.upSprites;
    }

    public ArrayList <BufferedImage> getSpriteDown()
    {
        return this.downSprites;
    }

    public ArrayList <BufferedImage> getSpriteLeft()
    {
        return this.leftSprites;
    }

    public ArrayList <BufferedImage> getSpriteRight()
    {
        return this.rightSprites;
    }
}
