package assetloader.animation;

import java.io.IOException;
import java.io.File;

import java.util.ArrayList;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import assetloader.sprite.SpriteLoader;

public class IdleAnimationLoader extends AnimationLoader
{
    public IdleAnimationLoader()
    {
    }
    
    public IdleAnimationLoader(Entity e)
    {
        this.entity = e;
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

        this.spriteloader = new SpriteLoader();

        this.spriteloader.setIdleFileLeft(left);
        this.spriteloader.setIdleFileRight(right);

        this.spriteloader.loadIdleImages();
    }

    @Override
    public void draw(Graphics2D g)
    {
        BufferedImage sprite = null;

        switch(this.entity.getFacingDirection())
        {
            case LEFT:
                sprite = this.getSpriteLoader().idleSpritesLeft.get(this.currentSprite);
                break;
            case RIGHT:
                sprite = this.getSpriteLoader().idleSpritesRight.get(this.currentSprite);
                break;
        }

        g.drawImage(sprite, this.entity.getX(), this.entity.getY(), Entity.FINAL_SPRITE_SIZE, Entity.FINAL_SPRITE_SIZE, null);
    }
}
