package assetloader.map;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import java.util.ArrayList;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

public class MapLoader
{
    private ArrayList <BufferedImage> tileMap = new ArrayList<>();
    private ArrayList <String> filePath = new ArrayList<>();

    public MapLoader(ArrayList <String> filePath)
    {
        this.filePath = filePath;
    }
    
    public MapLoader()
    {
    }

    public void loadFilesFromFolder(String path) throws FileNotFoundException
    {
        File folder = new File(path);
        for(File file : folder.listFiles())
        {
            this.filePath.add(file.getPath());
        }
    }

    public void loadImageFromFilePath() throws IOException
    {
        for(int i = 0; i < this.filePath.size(); i++)
        {
            File file = new File(this.filePath.get(i));
            this.tileMap.add(ImageIO.read(file));
        }
    }

    public void setFilePath(ArrayList <String> path)
    {
        this.filePath = path;
    }

    public ArrayList <BufferedImage> getTileMap()
    {
        return this.tileMap;
    }
}
