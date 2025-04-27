import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame{
    private Game game;
    private Player player;
    private Image board;

    public GameViewer(Game game){
        this.game = game;
        player = new Player();
        game.setSpinning(false);

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

        int rate = 0;
        if (game.getSpinning()){
            while (rate < 4){
                for (int i = 0; i < 19; i++){
                    try {
                        Thread.sleep(rate * 50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    game.getWheel().get(i).draw(g);
                }
                rate += 1;
                for (int i = 0; i < 19; i++){
                    try {
                        Thread.sleep(rate * 50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    game.getWheel().get(i + 19).draw(g);
                }
                rate += 1;
            }
            for (int i = 0; i < 38; i++){
                if (game.getWheel().get(i).getVal() == game.getChoice()){
                    game.getWheel().get(i).draw(g);
                    break;
                }
                try {
                    Thread.sleep(rate * 50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                game.getWheel().get(i).draw(g);
            }
        }
        game.setSpinning(false);

        g.drawString("" + game.getChoice(), 275, 450);
    }
}
