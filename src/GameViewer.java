import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame{
    private Game game;
    private Player player;
    private Image board;

    public GameViewer(Game game){
        this.game = game;
        player = new Player();

        this.setSize(2000, 1000);
        this.setTitle("Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public void paint(Graphics g){

    }
}
