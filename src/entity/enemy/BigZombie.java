package entity.enemy;

import java.io.IOException;

import entity.Entity;

public class BigZombie extends Entity
{
    public BigZombie()
    {
        try
        {
            this.initialize();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private void initialize() throws IOException
    {
        this.setWorldXPosition(222);
        this.setWorldYPosition(222);

        this.setX(222);
        this.setY(222);

        this.setSpeed(0);

        this.getAnimationHandler().setUpAnimation("assets/enemy/bigZombie/run/", "assets/enemy/bigZombie/idle/");
    }

    @Override
    public void update()
    {
        this.updateDirection();
        this.getAnimationHandler().update();
    }
}
