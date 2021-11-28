package assetloader.sprite;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.util.ArrayList;

import java.io.IOException;
import java.io.File;

public class SpriteLoader
{
    public ArrayList <BufferedImage> leftSprites = new ArrayList<>();
    public ArrayList <BufferedImage> rightSprites = new ArrayList<>();

    public ArrayList <BufferedImage> idleSpritesLeft = new ArrayList<>();
    public ArrayList <BufferedImage> idleSpritesRight = new ArrayList<>();

    public ArrayList <String> leftFiles = new ArrayList<>();
    public ArrayList <String> rightFiles = new ArrayList<>();

    public ArrayList <String> idleFilesLeft = new ArrayList<>();
    public ArrayList <String> idleFilesRight = new ArrayList<>();

    public SpriteLoader(ArrayList <String> leftFiles, ArrayList <String> rightFiles)
    {
        this.leftFiles = leftFiles;
        this.rightFiles = rightFiles;
    }

    public SpriteLoader(SpriteLoader spriteLoader)
    {
        this.leftFiles = spriteLoader.leftFiles;
        this.rightFiles = spriteLoader.rightFiles;

        this.leftSprites = spriteLoader.leftSprites;
        this.rightSprites = spriteLoader.rightSprites;
    }

    public SpriteLoader()
    {
    }

    public void loadIdleImages() throws IOException
    {
        this.loadImagesInOneDirection(this.idleSpritesLeft, this.idleFilesLeft);
        this.loadImagesInOneDirection(this.idleSpritesRight, this.idleFilesRight);
    }

    public void loadImages() throws IOException
    {
        this.loadImagesInOneDirection(this.leftSprites, this.leftFiles);
        this.loadImagesInOneDirection(this.rightSprites, this.rightFiles);
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

    public ArrayList <BufferedImage> getSpriteLeft()
    {
        return this.leftSprites;
    }

    public ArrayList <BufferedImage> getSpriteRight()
    {
        return this.rightSprites;
    }

    public void setIdleFileLeft(ArrayList <String> idleSprite)
    {
        this.idleFilesLeft = idleSprite;
    }

    public void setIdleFileRight(ArrayList <String> idleSprite)
    {
        this.idleFilesRight = idleSprite;
    }
}
