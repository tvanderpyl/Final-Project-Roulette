import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Game implements MouseListener, MouseMotionListener {
    private Player player;
    private Ball ball;
    private Board board;
    private GameViewer window;

    public Game(){
        this.player = new Player();
        this.ball = new Ball(0, 0);
        this.board = new Board();
        this.window = new GameViewer(ball);
    }

    public int spinWheel(){

    }

    public int select(){

    }

    public void placeBet(int betNumber) {
        player.setBet(betNumber);
    }
}

public static void main(String[] args) {
    new Game();
}


