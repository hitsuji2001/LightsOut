package assetloader.animation;

import java.util.ArrayList;

import java.io.File;
import java.io.IOException;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import assetloader.sprite.SpriteLoader;

public class MovingAnimationLoader extends AnimationLoader
{
    public MovingAnimationLoader()
    {
    }

    public MovingAnimationLoader(Entity e)
    {
        this.setEntity(e);
    }

    @Override
    public void loadFilesFromFolder(String folder) throws IOException
    {
        File leftFiles = new File(folder + "left");
        File rightFiles = new File(folder + "right");

        ArrayList <String> left = new ArrayList<>();
        ArrayList <String> right = new ArrayList<>();

        for(File f : leftFiles.listFiles()) left.add(f.getPath());
        for(File f : rightFiles.listFiles()) right.add(f.getPath());

        this.setSpriteLoader(new SpriteLoader(left, right));
        this.getSpriteLoader().loadImages();
    }

    @Override
    public void draw(Graphics2D g)
    {
        BufferedImage sprite = null;

        switch(this.getEntity().getFacingDirection())
        {
            case LEFT:
                sprite = this.getSpriteLoader().leftSprites.get(this.currentSprite);
                break;
            case RIGHT:
                sprite = this.getSpriteLoader().rightSprites.get(this.currentSprite);
                break;
        }

        g.drawImage(sprite, this.getEntity().getX(), this.getEntity().getY(), Entity.FINAL_SPRITE_SIZE, Entity.FINAL_SPRITE_SIZE, null);
    }
}
