package entity;

import game.Game;
import game.KeyHandler;

import java.io.IOException;

import java.awt.Graphics2D;

public class Player extends Entity
{
    // Keyhandler for player
    private KeyHandler keyHandler;

    public Player(KeyHandler keyHandler)
    {
        this.keyHandler = keyHandler;

        try
        {
            this.initializePlayer();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    private void initializePlayer() throws IOException
    {
        // Basic Attributes
        this.x = 100;
        this.y = 100;
        this.speed = 3;

        this.animationHandler.setUpAnimation("assets/player/run/", "assets/player/idle/");
    }

    @Override
    public void move()
    {
        if(this.keyHandler.isUpPressed)
        {
            this.moveUp();
        }
        else if(this.keyHandler.isDownPressed)
        {
            this.moveDown();
        }
        else if(this.keyHandler.isLeftPressed)
        {
            this.facingDirection = FacingDirection.LEFT;
            this.moveLeft();
        }
        else if(this.keyHandler.isRightPressed)
        {
            this.facingDirection = FacingDirection.RIGHT;
            this.moveRight();
        }
    }

    @Override
    public void moveUp()
    {
        this.y -= this.speed * Game.deltaTime;
    }

    @Override
    public void moveDown()
    {
        this.y += this.speed * Game.deltaTime;
    }

    @Override
    public void moveLeft()
    {
        this.x -= this.speed * Game.deltaTime;
    }

    @Override
    public void moveRight()
    {
        this.x += this.speed * Game.deltaTime;
    }

    @Override
    public boolean isMoving()
    {
        return this.keyHandler.isKeyPressed();
    }

    @Override
    public void draw(Graphics2D g)
    {
        this.animationHandler.play(g);
    }
}
