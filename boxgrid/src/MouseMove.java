/*
* MouseEventDemo.java
*/

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class MouseMove extends JPanel
        implements MouseListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BlankArea blankArea;
    JTextArea textArea;
    static final String NEWLINE = System.getProperty("line.separator");
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("MouseEventDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        JComponent newContentPane = new MouseMove();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false); // This is so the grid don't break :P
    }
    
    public MouseMove() {
        super(new GridLayout(0,1));
        blankArea = new BlankArea(Color.YELLOW);
        add(blankArea);
        //Register for mouse events on blankArea and the panel.
        blankArea.addMouseListener(this);
        addMouseListener(this);
        setPreferredSize(new Dimension(530, 530));
    }
    
    void eventOutput(String eventDescription, MouseEvent e) {
    	System.out.println(eventDescription + " detected on "
                + e.getComponent().getClass().getName()
                + "." + NEWLINE);
    }
    
    public void mousePressed(MouseEvent e) {
/*        eventOutput("Mouse pressed (# of clicks: "
                + e.getClickCount() + ") and had " , e);
        Point p = e.getPoint();
        int X = (int)p.getX();
        int Y = (int)p.getY();
        int x = X/(e.getComponent().getWidth()/27);
        int y = Y/(e.getComponent().getWidth()/27);

        Box.changeState(x,y);*/
    }
    
    public void mouseReleased(MouseEvent e) {
    	Point p = e.getPoint();
    	int X = (int)p.getX();
    	int Y = (int)p.getY();
        int x = X/(e.getComponent().getWidth()/27);
        int y = Y/(e.getComponent().getWidth()/27);

    	blankArea.repaint();
        /*eventOutput("Mouse released with button " + String.format("%d",e.getButton())+ "(# of clicks: "
                + e.getClickCount() + ") Point=" + String.format("%d,%d",X,Y), e);*/

        eventOutput(String.format("x: %s y: %s", x, y),e);
        eventOutput(String.format("X: %s Y: %s", X, Y),e);

        Box.changeState(x,y);
    }
    
    public void mouseEntered(MouseEvent e) {

    }
    
    public void mouseExited(MouseEvent e) {
    }
    
    public void mouseClicked(MouseEvent e) {
    }
}
