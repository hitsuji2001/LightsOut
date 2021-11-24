package window;

import game.Game;

import javax.swing.JFrame;

public class GameWindow extends JFrame
{
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    private Game game = new Game();

    private static final String TITLE = "Lights Out";

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

        //this.setResizable(false);

        this.setLocationRelativeTo(null);

        // Start Game Thread
        this.game.startGameThread();
    }
}
