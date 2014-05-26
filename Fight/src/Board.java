
import javax.swing.*;
import java.awt.*;

public class Board extends JTextArea {
    public static final int SIZE = 30;

    public Board(Color color) {
        setBackground(color);
    }

    public void paint(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        // Background
        g.setColor(Color.BLACK);
        g.fillRect(0,0, width, height);

        // Cycle through each box and set each box on the grid
        //System.out.println(Box.boxes.size());
        for (Box box : Box.boxes) {
            //g.fillRect(box.x * SIZE, box.y * SIZE, SIZE, SIZE);
            g.drawImage(box.character.getIcon(), box.x * SIZE, box.y * SIZE, null);

            // Colors
            int health = Integer.valueOf(box.character.getHealth());
            String space = " ";
            if (health == 100) {
                g.setColor(Color.cyan);
            }
            else if (health > 80) {
                space = "   ";
                g.setColor(Color.cyan);
            }
            else if (health > 50) {
                space = "   ";
                g.setColor(Color.ORANGE);
            }
            else if (health > 10) {
                g.setColor(Color.YELLOW);
                space = "   ";
            }
            else {
                g.setColor(Color.RED);
                space = "    ";
            }

            g.drawString(space+box.character.getHealth(), box.x * SIZE, (box.y * SIZE)-1);
        }

        // Grid lines
        g.setColor(Color.GREEN);
        for (int x = SIZE; x <= width-SIZE; x += SIZE) {
            g.drawLine(x, SIZE, x, width-SIZE);
            g.drawLine(SIZE, x, height-SIZE, x);
        }

        //updateUI();
        repaint();
    }
}
