package assetloader.animation;

import entity.Entity;
import assetloader.sprite.SpriteLoader;

import java.awt.Graphics2D;

import java.io.IOException;

public class AnimationLoader
{
    private SpriteLoader spriteloader = new SpriteLoader();
    private Entity entity;

    public static final int ANIMATION_FRAMES = 4;
    public int currentSprite = 0;
    public int frameCounter = 0;

    public AnimationLoader()
    {
    }

    public AnimationLoader(Entity entity)
    {
        this.entity = entity;
    }

    public void updateSprite()
    {
        frameCounter++;

        if(frameCounter > 10)
        {
            this.currentSprite++;
            if(currentSprite >= ANIMATION_FRAMES) currentSprite = 0;
            frameCounter = 0;
        }
    }

    public void loadFilesFromFolder(String folder) throws IOException
    {
    }

    public void draw(Graphics2D g)
    {
    }

    public void play()
    {
    }

    public SpriteLoader getSpriteLoader()
    {
        return this.spriteloader;
    }

    public Entity getEntity()
    {
        return this.entity;
    }

    public void setSpriteLoader(SpriteLoader s)
    {
        this.spriteloader = s;
    }

    public void setEntity(Entity e)
    {
        this.entity = e;
    }
}
