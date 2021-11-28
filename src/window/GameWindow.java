package window;

import game.Game;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class GameWindow extends JFrame
{
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    private Game game = new Game();

    private static final String TITLE = "Lights Out";
    private static final ImageIcon icon = new ImageIcon("assets/icon/knight_m_hit_anim_f0.png");

    public GameWindow()
    {
        super(TITLE);

        // Add new elements here
        this.add(this.game);

        // Pack all the components to fit the screen
        this.pack();

        // Set up window
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(icon.getImage());

        //this.setResizable(false);

        this.setLocationRelativeTo(null);

        // Start Game Thread
        this.game.startGameThread();
    }
}
