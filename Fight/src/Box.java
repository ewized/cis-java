import java.util.ArrayList;
import java.util.List;

public class Box {
    public static List<Box> boxes = new ArrayList<Box>();

    public int x;
    public int y;
    public final Character character;

    public Box(int x, int y, Character character) {
        this.x = x;
        this.y = y;
        this.character = character;
        boxes.add(this);
    }

/*
    public static void changeState(int x, int y) {
        if (x == 0 || x == Box.grid(Game.inst.getWidth()-Board.SIZE)) return;
        if (y == 0 || y == Box.grid(Game.inst.getHeight()-Board.SIZE)) return;

        if (boxes.contains(new Box(x,y))) {
            boxes.remove(new Box(x,y));
        }
        else {
            boxes.add(new Box(x, y));
        }
    }
*/

    // Gets the grid posistion
    public static int grid(int pos) {
        int width = Game.inst.board.getWidth();
        return pos/(width/(width/Board.SIZE));
    }

    // Used for the .contains
    @Override
    public boolean equals(Object box) {
        if (box instanceof Box) {
            Box temp = (Box)box;
            return hashCode() == temp.hashCode();
        }
        return false;
    }

    // Used for the .contains
    @Override
    public int hashCode() {
        return Integer.valueOf(x + "" + y);
    }

}
