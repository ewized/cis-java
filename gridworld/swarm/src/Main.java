import info.gridworld.actor.*;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.world.World;

import java.awt.*;

@SuppressWarnings("unchecked")
public class Main {

    public static void main(String[] args) {
        Grid grid = new BoundedGrid(22, 45);

        ActorWorld world = new ActorWorld(grid);

        world.add(new Pooper());

        world.show();
    }
}
