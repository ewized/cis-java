import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyEvents implements KeyListener {
    boolean turn = true; // kill toggleer

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Game.inst.hero.move(e);
        Game.inst.monster.move(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Check if the hero around a monster
        Box box = Game.inst.hero.box;
        Box mob = Game.inst.monster.box;
        for (int x = box.x-1; x < box.x+1; x++) {
            for (int y = box.y-1; y < box.y+1; y++) {
                if (mob.x == x && mob.y == y) {

                    // Kill each other
                    //while (Game.inst.hero.health > 0 || Game.inst.monster.health > 0) {
                        if (turn) {
                            Hit h = new Hit();
                            Game.inst.hero.saveHit(h);
                            Game.inst.hero.insert(h);
                        }
                        else {
                            Hit h = new Hit();

                            Game.inst.monster.saveHit(h);
                            Game.inst.monster.insert(h);
                        }

                        Game.inst.hero.nextEvent();
                        Game.inst.monster.nextEvent();

                        turn = !turn;
                    //}

                    if (Game.inst.monster.health <= 0) {
                        Game.inst.monster.box.x=-1;
                        Game.inst.monster.box.y=-1;
                        JOptionPane.showMessageDialog(null, "The monster died! Spawning in new monster!");
                        Game.inst.monster = new Monster();
                        //System.exit(0);
                    }

                    // Are we dead
                    if (Game.inst.hero.health <= 0) {
                        Game.inst.hero.box.x=-1;
                        Game.inst.hero.box.y=-1;
                        JOptionPane.showMessageDialog(null, "The hero died! Spawning in new hero!");
                        Game.inst.hero = new Hero();
                        //System.exit(0);
                    }

                }
            }
        }
    }
}
