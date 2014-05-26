import java.util.ArrayList;
import java.util.List;

public class Box {
    public static List<Box> boxes = new ArrayList<Box>();

    public final int x;
    public final int y;

    public Box(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void changeState(int x, int y) {
        if (x == 0 || x == 26) return;
        if (y == 0 || y == 26) return;

        if (boxes.contains(new Box(x,y))) {
           boxes.remove(new Box(x,y));
        }
        else {
            boxes.add(new Box(x, y));
        }
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
