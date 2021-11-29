package assetloader.map;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;
import java.util.Random;

import java.io.PrintWriter;
import java.io.FileWriter;

public class LoadMapFromFile
{
    private File mapFile;
    private Scanner scanner;
    private Random random = new Random();

    public static int WORLD_MAP_SIZE_ROWS = 100;
    public static int WORLD_MAP_SIZE_COLUMNS = 100;

    private int map[][] = new int[WORLD_MAP_SIZE_ROWS][WORLD_MAP_SIZE_COLUMNS];

    private FileWriter writer;
    private PrintWriter printer;

    LoadMapFromFile()
    {
        try
        {
            this.initialize();
            this.resetMap();
            this.loadMap();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void initialize() throws FileNotFoundException
    {
        this.mapFile = new File("src/mapgen/overworld_map.txt");
        this.scanner = new Scanner(this.mapFile);
    }

    public void loadMap()
    {
        for(int i = 0; i < WORLD_MAP_SIZE_ROWS; i++)
        {
            for(int j = 0; j < WORLD_MAP_SIZE_COLUMNS; j++)
            {
                this.map[i][j] = this.scanner.nextInt();
            }
        }
    }

    public void resetMap() throws IOException
    {
        this.writer = new FileWriter(this.mapFile);
        this.printer = new PrintWriter(this.writer);


        for(int i = 0; i < WORLD_MAP_SIZE_ROWS; i++)
        {
            for(int j = 0; j < WORLD_MAP_SIZE_COLUMNS; j++)
            {
                int temp = this.random.nextInt(4);
                //left
                if(j == 0) printer.print("37 ");
                //top
                else if(i == 0) printer.print("37 ");
                //bottom
                else if(i == WORLD_MAP_SIZE_ROWS - 1) printer.print("37 ");
                //right
                else if(j == WORLD_MAP_SIZE_COLUMNS - 1) printer.print("37 ");
                else printer.print(temp + " ");
            }
            printer.println();
        }
        printer.close();
    }

    public int[][] getMap()
    {
        return this.map;
    }
}
