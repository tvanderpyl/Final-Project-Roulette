public class Game {
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
}
