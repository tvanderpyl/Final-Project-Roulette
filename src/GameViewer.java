import javax.swing.*;

public class GameViewer extends JFrame{
    private Ball b;

    public GameViewer(Ball b){
        this.b = b;

        this.setSize(2000, 1000);
        this.setTitle("Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void paint(){
        
    }
}
