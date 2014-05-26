import java.awt.*;
import java.awt.event.MouseListener;

public class MouseEvent implements MouseListener {
    void eventOutput(String eventDescription, java.awt.event.MouseEvent e) {
        System.out.println(eventDescription + " detected on "
                + e.getComponent().getClass().getName()
                + ".");
    }

    public void mousePressed(java.awt.event.MouseEvent e) {
/*        eventOutput("Mouse pressed (# of clicks: "
                + e.getClickCount() + ") and had " , e);
        Point p = e.getPoint();
        int X = (int)p.getX();
        int Y = (int)p.getY();
        int x = X/(e.getComponent().getWidth()/27);
        int y = Y/(e.getComponent().getWidth()/27);

        Box.changeState(x,y);*/
    }

    public void mouseReleased(java.awt.event.MouseEvent e) {
        Point p = e.getPoint();
        int X = (int)p.getX();
        int Y = (int)p.getY();
        int x = Box.grid(X);
        int y = Box.grid(Y);

        Game.inst.repaint();
        /*eventOutput("Mouse released with button " + String.format("%d",e.getButton())+ "(# of clicks: "
                + e.getClickCount() + ") Point=" + String.format("%d,%d",X,Y), e);*/

        //eventOutput(String.format("x: %s y: %s", x, y),e);
        //eventOutput(String.format("X: %s Y: %s", X, Y),e);

        if (e.getButton() == 1) {
            //new Box(x,y, new Hero());
        }
        else {
            //new Box(x,y, new Monster());
        }
    }

    public void mouseEntered(java.awt.event.MouseEvent e) {

    }

    public void mouseExited(java.awt.event.MouseEvent e) {
        /*int SIZE = Integer.valueOf(JOptionPane.showInputDialog("Enter the grid size: "));
        //Game.inst.setPreferredSize();
        Game.inst.setSize(new Dimension(SIZE, SIZE));*/
    }

    public void mouseClicked(java.awt.event.MouseEvent e) {
    }
}
