package entity;

import java.awt.Graphics2D;

public class Entity
{
    private int x;
    private int y;
    private int speed;

    private static final int SPRITE_SIZE = 16; // 16px sprite
    private static final int SPRITE_SCALER = 4;
    private static final int FINAL_SPRITE_SIZE = SPRITE_SCALER * SPRITE_SIZE;

    public Entity(int x, int y, int speed)
    {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
    
    public Entity()
    {
    }

    public void draw(Graphics2D g)
    {
        g.fillRect(this.x, this.y, FINAL_SPRITE_SIZE, FINAL_SPRITE_SIZE);
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
