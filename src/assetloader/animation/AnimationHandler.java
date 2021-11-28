package assetloader.animation;

import entity.Entity;

import java.io.IOException;

import java.awt.Graphics2D;

public class AnimationHandler
{
    private Entity entity;

    private MovingAnimationLoader movingAnimationLoader;
    private IdleAnimationLoader idleAnimationLoader;

    public AnimationHandler(Entity e)
    {
        this.entity = e;
        this.movingAnimationLoader = new MovingAnimationLoader(this.entity);
        this.idleAnimationLoader = new IdleAnimationLoader(this.entity);
    }

    public void setUpAnimation(String runAnimationFolder, String idleAnimationFolder) throws IOException
    {
        this.movingAnimationLoader.loadFilesFromFolder(runAnimationFolder);
        this.idleAnimationLoader.loadFilesFromFolder(idleAnimationFolder);
    }

    public void play(Graphics2D g)
    {
        if(this.entity.isMoving()) this.movingAnimationLoader.draw(g);
        else this.idleAnimationLoader.draw(g);
    }

    public void update()
    {
        if(this.entity.isMoving()) this.movingAnimationLoader.updateSprite();
        else this.idleAnimationLoader.updateSprite();
    }
}
