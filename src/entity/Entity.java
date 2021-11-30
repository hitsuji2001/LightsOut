package entity;

import java.awt.Graphics2D;

import assetloader.animation.AnimationHandler;

public class Entity
{
    private int x;
    private int y;

    private int worldXPosition;
    private int worldYPosition;

    private int speed;

    private int currentDirection = 0;

    public boolean isMoving = false;
    public float moveTimer = 0.0f;

    private FacingDirection facingDirection = FacingDirection.RIGHT;

    private AnimationHandler animationHandler = new AnimationHandler(this);

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

    public void move()
    {
        switch(this.currentDirection)
        {
            case 0:
                this.moveRight();
                this.facingDirection = FacingDirection.RIGHT;
                break;
            case 1:
                this.moveDown();
                break;
            case 2:
                this.moveLeft();
                this.facingDirection = FacingDirection.LEFT;
                break;
            case 3:
                this.moveUp();
                break;
        }
    }

    public void debugDraw(Graphics2D g)
    {
        g.fillRect(this.x, this.y, FINAL_SPRITE_SIZE, FINAL_SPRITE_SIZE);
    }

    public void draw(Graphics2D g)
    {
        this.animationHandler.play(g);
    }

    public void update()
    {
        this.updateDirection();
        this.move();
        this.animationHandler.update();
    }

    public void updateDirection()
    {
        if(this.moveTimer >= 6.9f)
        {
            this.moveTimer = 0;
            this.currentDirection++;
            if(this.currentDirection > 3) this.currentDirection = 0;
        }
        else
        {
            this.moveTimer += 0.1f;
        }
    }

    public void moveUp()
    {
        this.y -= this.speed;
        this.isMoving = true;
    }

    public void moveDown()
    {
        this.y += this.speed;
        this.isMoving = true;
    }

    public void moveLeft()
    {
        this.x -= this.speed;
        this.isMoving = true;
    }

    public void moveRight()
    {
        this.x += this.speed;
        this.isMoving = true;
    }

    public boolean isMoving()
    {
        return this.isMoving;
    }

    public int getX()
    {
        return this.x;
    }

    public int getWorldXPosition()
    {
        return this.worldXPosition;
    }

    public int getWorldYPosition()
    {
        return this.worldYPosition;
    }

    public int getY()
    {
        return this.y;
    }

    public int getSpeed()
    {
        return this.speed;
    }

    public AnimationHandler getAnimationHandler()
    {
        return this.animationHandler;
    }

    public FacingDirection getFacingDirection()
    {
        return this.facingDirection;
    }

    public void setWorldXPosition(int x)
    {
        this.worldXPosition = x;
    }

    public void setFacingDirection(FacingDirection dir)
    {
        this.facingDirection = dir;
    }

    public void setWorldYPosition(int y)
    {
        this.worldYPosition = y;
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
