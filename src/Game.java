import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Game implements MouseListener {

    public static final int RED = 0;
    public static final int BLACK = 1;
    public static final int GREEN = 2;
    public static final int DOUBLE_ZERO = 0;
    private static final int SINGLE_ZERO = -1;

    private Player player;
    private GameViewer window;
    private int bets[] = new int[42];
    private ArrayList<Button> buttons = new ArrayList<Button>();
    private int choice;
    private ArrayList<Wheel> wheel = new ArrayList<Wheel>();
    private boolean spinning;

    public Game() {
        this.player = new Player();
        this.window = new GameViewer(this);
        window.addMouseListener(this);
    }

    public void run() {
        this.makeButtons();
        this.makeWheel();
        window.repaint();
    }

    public void makeWheel() {
        Image image;
        for (int i = 0; i < 38; i++) {
            image = new ImageIcon("src/Images/Wheel" + (i + 1) + ".png").getImage();
            wheel.add(new Wheel(image, window));
        }

        // Set values
        wheel.get(0).setVal(3);
        wheel.get(1).setVal(15);
        wheel.get(2).setVal(34);
        wheel.get(3).setVal(22);
        wheel.get(4).setVal(5);
        wheel.get(5).setVal(17);
        wheel.get(6).setVal(32);
        wheel.get(7).setVal(20);
        wheel.get(8).setVal(7);
        wheel.get(9).setVal(11);
        wheel.get(10).setVal(30);
        wheel.get(11).setVal(26);
        wheel.get(12).setVal(9);
        wheel.get(13).setVal(28);
        wheel.get(14).setVal(-1);
        wheel.get(15).setVal(2);
        wheel.get(16).setVal(14);
        wheel.get(17).setVal(35);
        wheel.get(18).setVal(23);
        wheel.get(19).setVal(4);
        wheel.get(20).setVal(16);
        wheel.get(21).setVal(33);
        wheel.get(22).setVal(21);
        wheel.get(23).setVal(6);
        wheel.get(24).setVal(18);
        wheel.get(25).setVal(31);
        wheel.get(26).setVal(19);
        wheel.get(27).setVal(8);
        wheel.get(28).setVal(12);
        wheel.get(29).setVal(29);
        wheel.get(30).setVal(25);
        wheel.get(31).setVal(10);
        wheel.get(32).setVal(27);
        wheel.get(33).setVal(0);
        wheel.get(34).setVal(1);
        wheel.get(35).setVal(13);
        wheel.get(36).setVal(36);
        wheel.get(37).setVal(24);

        //Set colors
        wheel.get(0).setColor(RED);
        wheel.get(1).setColor(BLACK);
        wheel.get(2).setColor(RED);
        wheel.get(3).setColor(BLACK);
        wheel.get(4).setColor(RED);
        wheel.get(5).setColor(BLACK);
        wheel.get(6).setColor(RED);
        wheel.get(7).setColor(BLACK);
        wheel.get(8).setColor(RED);
        wheel.get(9).setColor(BLACK);
        wheel.get(10).setColor(RED);
        wheel.get(11).setColor(BLACK);
        wheel.get(12).setColor(RED);
        wheel.get(13).setColor(BLACK);
        wheel.get(14).setColor(GREEN);

        for (int i = 15; i <= 32; i++) {
            if (i % 2 == 1) {
                wheel.get(i).setColor(BLACK);
            } else {
                wheel.get(i).setColor(RED);
            }
        }

        wheel.get(33).setColor(GREEN);
        wheel.get(34).setColor(RED);
        wheel.get(35).setColor(BLACK);
        wheel.get(36).setColor(RED);
        wheel.get(37).setColor(BLACK);
    }

    public void makeButtons() {
        int x = 1150;
        int y = 40;
        Image image;
        for (int i = 0; i < 19; i++) {
            image = new ImageIcon("src/Images/sqaure" + (i * 2) + ".png").getImage();
            buttons.add(new Button(window, image, x, y, 40, 40));
            image = new ImageIcon("src/Images/sqaure" + ((i * 2) + 1) + ".png").getImage();
            buttons.add(new Button(window, image, x + 100, y, 40, 40));
            y += 43;
        }

        image = new ImageIcon("src/Images/even.png").getImage();
        buttons.add(new Button(window, image, 700, 250, 150, 150));
        image = new ImageIcon("src/Images/odd.png").getImage();
        buttons.add(new Button(window, image, 900, 250, 150, 150));

        image = new ImageIcon("src/Images/Red.png").getImage();
        buttons.add(new Button(window, image, 700, 80, 150, 150));
        image = new ImageIcon("src/Images/Black.png").getImage();
        buttons.add(new Button(window, image, 900, 80, 150, 150));

        image = new ImageIcon("src/Images/spin.png").getImage();
        buttons.add(new Button(window, image, 700, 625, 350, 200));

    }

    public void addBet(int index) {
        // get the bet
        player.editMoney(-(player.getBet()));
        bets[index] = bets[index] + player.getBet();
    }

    public void setSpinning(boolean bool) {
        this.spinning = bool;
    }

    public boolean getSpinning() {
        return spinning;
    }

    public int spin() {
        int numberFromZeroToThirtySeven = (int) (Math.random() * 38);
        this.spinning = true;
        window.repaint();

        return numberFromZeroToThirtySeven;
    }

    public void calculate(int numberFromZeroToThirtySeven) {

        int actualNumber = numberFromZeroToThirtySeven - 1;

        if (actualNumber == SINGLE_ZERO) {
            player.editMoney(bets[0] * 35);
        }

        if (actualNumber == DOUBLE_ZERO) {
            player.editMoney(bets[1] * 35);
        }

        // Checks for match to exact number bet
        for (int i = 1; i < 37; i++) {
            if (i == actualNumber) {
                player.editMoney(bets[i + 1] * 35);
            }
        }

        // Checks for match to even or odd bet
        if (actualNumber >= 1 && actualNumber <= 36) {
            if (actualNumber % 2 == 0) {
                player.editMoney(bets[38] * 2);
            } else {
                player.editMoney(bets[39] * 2);
            }
        }

        // Checks for match to red or black
        // FOR EACH LOOP!!
        for (Wheel wheelSection : wheel) {
            if (actualNumber == wheelSection.getVal()) {
                int color = wheelSection.getColor();
                if (color == 0) {
                    player.editMoney(bets[40] * 2);
                } else if (color == 1) {
                    player.editMoney(bets[41] * 2);
                }
                break;
            }
        }

        for (int i = 0; i < 42; i++) {
            bets[i] = 0;
        }
    }

    public ArrayList<Button> getButtons() {
        return buttons;
    }

    public int getMoney() {
        return player.getMoney();
    }

    public int getChoice() {
        return choice;
    }

    public ArrayList<Wheel> getWheel() {
        return wheel;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("x = " + e.getX() + ", y = " + e.getY());
        for (int i = 0; i < buttons.size() - 1; i++) {
            if (buttons.get(i).isClicked(e.getX(), e.getY())) {
                if (player.getMoney() < player.getBet()) {
                    break;
                } else {
                    this.addBet(i);
                }
                window.repaint();
            }
        }
        if (buttons.get(42).isClicked(e.getX(), e.getY())) {
            this.choice = this.spin();
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