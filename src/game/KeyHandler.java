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
                this.isUpPressed = true;
                break;
            case KeyEvent.VK_S:
                this.isDownPressed = true;
                break;
            case KeyEvent.VK_A:
                this.isLeftPressed = true;
                break;
            case KeyEvent.VK_D:
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
                this.isUpPressed = false;
                break;
            case KeyEvent.VK_S:
                this.isDownPressed = false;
                break;
            case KeyEvent.VK_A:
                this.isLeftPressed = false;
                break;
            case KeyEvent.VK_D:
                this.isRightPressed = false;
                break;
        }
    }
}
