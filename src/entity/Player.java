package entity;

import game.Game;
import window.GameWindow;
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
        this.setWorldXPostition(960);
        this.setWorldYPosition(960);

        this.setX((int)(GameWindow.WINDOW_WIDTH / 2 - Entity.FINAL_SPRITE_SIZE / 2));
        this.setY((int)(GameWindow.WINDOW_HEIGHT / 2 - Entity.FINAL_SPRITE_SIZE / 2));

        this.setSpeed(3);

        this.getAnimationHandler().setUpAnimation("assets/player/run/", "assets/player/idle/");
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
            this.setFacingDirection(FacingDirection.LEFT);
            this.moveLeft();
        }
        else if(this.keyHandler.isRightPressed)
        {
            this.setFacingDirection(FacingDirection.RIGHT);
            this.moveRight();
        }
    }

    @Override
    public void moveUp()
    {
        this.setWorldYPosition((int)(this.getWorldYPosition() - this.getSpeed() * Game.deltaTime));
    }

    @Override
    public void moveDown()
    {
        this.setWorldYPosition((int)(this.getWorldYPosition() + this.getSpeed() * Game.deltaTime));
    }

    @Override
    public void moveLeft()
    {
        this.setWorldXPostition((int)(this.getWorldXPosition() - this.getSpeed() * Game.deltaTime));
    }

    @Override
    public void moveRight()
    {
        this.setWorldXPostition((int)(this.getWorldXPosition() + this.getSpeed() * Game.deltaTime));
    }

    @Override
    public boolean isMoving()
    {
        return this.keyHandler.isKeyPressed();
    }

    @Override
    public void draw(Graphics2D g)
    {
        this.getAnimationHandler().play(g);
    }
}
