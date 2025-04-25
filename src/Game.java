import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Game implements MouseListener{
    private Player player;
    private GameViewer window;
    private int bets[] = new int[40];
    private ArrayList<Button> buttons = new ArrayList<Button>();
    private int choice;

    public Game(){
        this.player = new Player();
        this.window = new GameViewer(this);
        window.addMouseListener(this);
    }

    public void run(){
        this.makeButtons();
        window.repaint();
    }

    public void makeButtons(){
        int x = 1150;
        int y = 40;
        Image image;
        for (int i = 0; i < 19; i++){
            image = new ImageIcon("src/Images/sqaure" + (i * 2) + ".png").getImage();
            buttons.add(new Button(window, image, x, y, 40, 40));
            image = new ImageIcon("src/Images/sqaure" + ((i * 2)+ 1) + ".png").getImage();
            buttons.add(new Button(window, image, x + 75, y, 40, 40));
            y += 43;
        }

        image = new ImageIcon("src/Images/even.png").getImage();
        buttons.add(new Button(window, image, 700, 250, 150, 150));
        image = new ImageIcon("src/Images/odd.png").getImage();
        buttons.add(new Button(window, image, 900, 250, 150, 150));

        image = new ImageIcon("src/Images/spin.png").getImage();
        buttons.add(new Button(window, image, 700, 625, 350, 200));
    }

    public void addBet(int index){
        // get the bet
        player.editMoney(-(player.getBet()));
        bets[index] = player.getBet();
    }

    public int spin(){
        return (int)(Math.random() * 38);
    }

    public void calculate(int choice){

        int actualNumber = choice - 1;

        for (int i = 0; i < 38; i++){
            if (i == choice) {
                player.editMoney(bets[i] * 35);
            }
        }
        if (actualNumber >= 1 && actualNumber <= 36) {
            if (actualNumber % 2 == 0) {
                player.editMoney(bets[38] * 2); // even bet
            } else {
                player.editMoney(bets[39] * 2); // odd bet
            }
        }
        for (int i = 0; i < 40; i++){
            bets[i] = 0;
        }
    }

    public ArrayList<Button> getButtons(){
        return buttons;
    }

    public int getMoney(){
        return player.getMoney();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("x = " + e.getX() + ", y = " + e.getY());
        for (int i = 0; i < 39; i++){
            if (buttons.get(i).isClicked(e.getX(), e.getY())){
                if (player.getMoney() < player.getBet()){
                    break;
                }
                else{
                    this.addBet(i);
                }
                window.repaint();
            }
        }
        if (buttons.get(40).isClicked(e.getX(), e.getY())){
            choice = this.spin();
            this.calculate(choice);
            System.out.println(player.getMoney());
            window.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}