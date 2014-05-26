import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public interface Character {
    public void move(KeyEvent direction);
    public BufferedImage getIcon();
    public String getHealth();
}
