import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame{
    private Game game;
    private Player player;
    private Image board;

    public GameViewer(Game game){
        this.game = game;
        player = new Player();

        this.setSize(1400, 900);
        this.setTitle("Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public void paint(Graphics g){

        g.setColor(Color.WHITE);
        g.drawRect(0, 0, 1400, 900);
        g.fillRect(0, 0, 1400, 900);

        for (int i = 0; i < 38; i++){
            Button button = game.getButtons().get(i);
            button.draw(g);
        }

        Button button = game.getButtons().get(38);
        button.draw(g);
        button = game.getButtons().get(39);
        button.draw(g);

        button = game.getButtons().get(40);
        button.draw(g);

        g.setColor(Color.BLACK);
        Font font = new Font("Font", Font.BOLD, 28);
        g.setFont(font);
        g.drawString("Player Balance " + game.getMoney(), 700, 575);
    }
}
