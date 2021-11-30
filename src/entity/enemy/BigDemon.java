package entity.enemy;

import java.io.IOException;

import entity.Entity;

public class BigDemon extends Entity
{
    public BigDemon()
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
        this.setWorldXPosition(690);
        this.setWorldYPosition(690);

        this.setX(300);
        this.setY(300);

        this.setSpeed(2);

        this.getAnimationHandler().setUpAnimation("assets/enemy/bigDemon/run/", "assets/enemy/bigDemon/idle/");
    }
}
