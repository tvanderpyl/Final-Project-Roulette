import javax.swing.*;
import java.awt.*;

public class Game{
    private Player player;
    private GameViewer window;
    private int bets[] = new int[38];

    public Game(){
        this.player = new Player();
        this.window = new GameViewer(this);
    }

    public void run(){
        this.getBet();
        int choice = this.spin();
        this.calculate(choice);
    }

    public void getBet(){
        // get the bet
    }

    public int spin(){
        return (int)(Math.random() * 38);
    }

    public void calculate(int choice){
        for (int i = 0; i < 38; i++){
            if (i == choice) {
                player.editMoney(bets[i]);
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}