package game;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener
{
    public boolean isUpPressed;
    public boolean isDownPressed;
    public boolean isLeftPressed;
    public boolean isRightPressed;

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_W:
                System.out.println("up pressed!");
                this.isUpPressed = true;
                break;
            case KeyEvent.VK_S:
                System.out.println("down pressed!");
                this.isDownPressed = true;
                break;
            case KeyEvent.VK_A:
                System.out.println("left pressed!");
                this.isLeftPressed = true;
                break;
            case KeyEvent.VK_D:
                System.out.println("right pressed!");
                this.isRightPressed = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_W:
                System.out.println("up released!");
                this.isUpPressed = false;
                break;
            case KeyEvent.VK_S:
                System.out.println("down released!");
                this.isDownPressed = false;
                break;
            case KeyEvent.VK_A:
                System.out.println("left released!");
                this.isLeftPressed = false;
                break;
            case KeyEvent.VK_D:
                System.out.println("right released!");
                this.isRightPressed = false;
                break;
        }
    }
}
