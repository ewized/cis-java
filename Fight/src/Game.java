/*
    name: Joshua Rodriguez
    program: Awesome game of awesomeness!
 */
import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {
    public Board board;
    public static Game inst;
    public Hero hero;
    public Monster monster;
    public static final int SIZE = 530; // make a square to keep things nice

    // Create the game
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                load();
            }
        });
        //new Game();
    }

    private static void load() {
        //Create and set up the window.
        JFrame frame = new JFrame("Hero's Fight");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new Game();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        // Show Desclamer
        JOptionPane.showMessageDialog(null, "Welcome to Hero's Fight Created by Joshua Rodriguez", "Hero's Fight", 1);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setIconImage(Game.inst.hero.getIcon());

    }

    private Game() {
        super(new GridLayout(0,1));


        board = new Board(Color.YELLOW);
        add(board);

        //Register for mouse events on blankArea and the panel.
        board.addMouseListener(new MouseEvent());
        board.addKeyListener(new KeyEvents());

        setPreferredSize(new Dimension(SIZE, SIZE));

        inst = this; // Game is a singleton

        // Character must be called after game crated its instance
        hero = new Hero();
        monster = new Monster();

    }

}
