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
        this.x = 200;
        this.y = 200;
        this.speed = 2;

        this.animationHandler.setUpAnimation("assets/enemy/bigDemon/run/", "assets/enemy/bigDemon/idle/");
    }
}
