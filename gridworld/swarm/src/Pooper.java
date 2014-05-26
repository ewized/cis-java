import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.Random;

public class Pooper extends Bug {
    Random rand = new Random();

    @Override
    public void move() {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next)) {
            moveTo(next);
        } else {
            removeSelfFromGrid();
        }

        if (rand.nextInt(100) > 75)
            poop(gr, loc);
    }

    // Get a random color for fun
    private Color randomColor() {
        return Color.getHSBColor(
            new Random().nextFloat(),
            new Random().nextFloat(),
            new Random().nextFloat()
        );
    }

    // What should the bug poop
    private void poop(Grid<Actor> grid, Location loc) {
        int type = rand.nextInt(75);

        Actor bug;
        if (type < 25) {
            bug = new Pooper();
        }
        else if (type > 75) {
            bug = new Flower();
        }
        //else if (type > 60){
            //bug = new Critter();
        //}
        else {
            bug = new Rock();
        }
        bug.setColor(randomColor());
        bug.putSelfInGrid(grid, loc);
    }
}
