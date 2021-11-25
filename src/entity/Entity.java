package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.io.IOException;

import java.util.ArrayList;

import game.Game;
import assetloader.SpriteLoader;

public class Entity
{
    public int x;
    public int y;
    public int speed;

    public ArrayList <String> spriteFileNameUp = new ArrayList<>();
    public ArrayList <String> spriteFileNameDown = new ArrayList<>();
    public ArrayList <String> spriteFileNameLeft = new ArrayList<>();
    public ArrayList <String> spriteFileNameRight = new ArrayList<>();

    public ArrayList <BufferedImage> spriteUp = new ArrayList<>();
    public ArrayList <BufferedImage> spriteDown = new ArrayList<>();
    public ArrayList <BufferedImage> spriteLeft = new ArrayList<>();
    public ArrayList <BufferedImage> spriteRight = new ArrayList<>();

    public SpriteLoader spriteLoader;
    public FacingDirection facingDirection = FacingDirection.LEFT;

    public enum FacingDirection
    {
        LEFT, RIGHT
    };

    public static final int SPRITE_SIZE = 16; // 16px sprite
    public static final int SPRITE_SCALER = 3;
    public static final int FINAL_SPRITE_SIZE = SPRITE_SCALER * SPRITE_SIZE;

    public Entity(int x, int y, int speed)
    {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
    
    public Entity()
    {
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
        SpriteLoader.loadFiles(this.spriteFileNameUp, this.spriteUp);
        SpriteLoader.loadFiles(this.spriteFileNameDown, this.spriteDown);
        SpriteLoader.loadFiles(this.spriteFileNameLeft, this.spriteLeft);
        SpriteLoader.loadFiles(this.spriteFileNameRight, this.spriteRight);
    }

    public void debugDraw(Graphics2D g)
    {
        g.fillRect(this.x, this.y, FINAL_SPRITE_SIZE, FINAL_SPRITE_SIZE);
    }

    public void draw(Graphics2D g)
    {
    }

    public void moveUp()
    {
        this.y -= this.speed * Game.deltaTime;
    }

    public void moveDown()
    {
        this.y += this.speed * Game.deltaTime;
    }

    public void moveLeft()
    {
        this.x -= this.speed * Game.deltaTime;
    }

    public void moveRight()
    {
        this.x += this.speed * Game.deltaTime;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public int getSpeed()
    {
        return this.speed;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
}
