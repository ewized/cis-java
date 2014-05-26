/*
 * BlankArea.java is used by:
 *    MouseEventDemo.java.
 *    MouseMotionEventDemo.java
 */

import java.awt.Component;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class BlankArea extends Component {
    public static final int SIZE = 20;

    public BlankArea(Color color) {
        setBackground(color);
       
    }

    public void paint(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        for (int x = SIZE; x <= width-SIZE; x += SIZE) {
            //g.setColor(Color.cyan);
            g.drawLine(x, SIZE, x, width-SIZE);
            g.drawLine(SIZE, x, height-SIZE, x);
        }

        // Cycle through each box and set each box on the grid
        for (Box box : Box.boxes) {
            g.fillRect(box.x * SIZE, box.y * SIZE, SIZE, SIZE);
        }

/*
        for (int x = SIZE; x < width-SIZE; x += SIZE) {
            for (int y = SIZE; y < height-SIZE; y += SIZE) {
                g.setColor(Color.getHSBColor(y,x*100/5,y*100+x*100/5));
                g.drawLine(x,y,width-x,height-y);
            }
        }
*/
        repaint();
    }

}
	
