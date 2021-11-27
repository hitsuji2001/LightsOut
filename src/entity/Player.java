package entity;

import game.KeyHandler;

import java.io.IOException;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Player extends Entity
{
    private KeyHandler keyHandler;

    public static final int ANIMATION_FRAMES = 4;

    public int currentSprite = 0;
    public int animationFrameCounter = 0;

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

        // Load Sprite
        this.setUpSprite();
        this.loadSprite();
    }

    private void setUpSprite()
    {
        for(int i = 0; i < ANIMATION_FRAMES; i++)
        {
            String temp = "assets/player/run/right/" + "knight_f_run_anim_f" + i + ".png";
            this.spriteFileNameRight.add(temp);
        }

        for(int i = 0; i < ANIMATION_FRAMES; i++)
        {
            String temp = "assets/player/run/left/" + "knight_f_run_anim_f" + i + ".png";
            this.spriteFileNameLeft.add(temp);
        }
    }

    public void update()
    {
        this.move();
        //if(this.keyHandler.isKeyPressed())
            this.updateSprite();
    }

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

    private void updateSprite()
    {
        animationFrameCounter++;

        if(animationFrameCounter > 10)
        {
            this.currentSprite++;
            if(currentSprite >= ANIMATION_FRAMES) currentSprite = 0;
            animationFrameCounter = 0;
        }
    }

    @Override
    public void draw(Graphics2D g)
    {
        BufferedImage sprite = null;

        switch(this.facingDirection)
        {
            case LEFT:
                sprite = this.spriteLeft.get(currentSprite);
                break;
            case RIGHT:
                sprite = this.spriteRight.get(currentSprite);
                break;
        }

        g.drawImage(sprite, this.x, this.y, FINAL_SPRITE_SIZE, FINAL_SPRITE_SIZE, null);
    }
}
