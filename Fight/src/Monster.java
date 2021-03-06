import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Monster extends Simulator implements Character {
    public Box box;

    public Monster() {
        Random r = new Random();
        int math = ((Game.SIZE-Board.SIZE)/Board.SIZE);
        box = new Box(r.nextInt(math)+1,r.nextInt(math)+1,this);

        events = new ListQueue();
    }

    private static BufferedImage icon;
    static {
        try {
            icon = ImageIO.read(Game.inst.getClass().getResourceAsStream("monster.png"));
        } catch (IOException e) {
            System.out.println("Can not find hero picture!");
        }
    }

    @Override
    public void move(KeyEvent direction) {
        int key = direction.getKeyCode();
        int[] keys = {38, 37, 40, 39};

        if (key == keys[0]) { // w
            if (box.y-1 == 0)
                box.y = Game.SIZE/Board.SIZE;

            box.y--;
        }
        else if (key == keys[1]) { // a
            if (box.x-1 == 0)
                box.x = Game.SIZE/Board.SIZE;

            box.x--;
        }
        else if (key == keys[2]) { // s
            if (box.y+1 == Game.SIZE/Board.SIZE)
                box.y = 0;

            box.y++;
        }
        else if (key == keys[3]) { // d
            if (box.x+1 == Game.SIZE/Board.SIZE)
                box.x = 0;

            box.x++;
        }
    }

    @Override
    public BufferedImage getIcon() {
        return icon;
    }

    public void saveHit(Hit h){
        if(h.getHit() == 3) health-=20;
        else if(h.getHit() == 2) health-=10;
        else if(h.getHit() == 1) health-=5;
    }

    public String getHealth() {
        return ""+health;
    }
}
