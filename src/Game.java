import javax.swing.*;
import java.awt.*;

public class Game{
    private Player player;
    private GameViewer window;

    public Game(){
        this.player = new Player();
        this.window = new GameViewer(this);
    }

    public static void main(String[] args) {
        Game game = new Game();
    }
}