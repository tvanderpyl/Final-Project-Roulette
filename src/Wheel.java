import java.awt.*;

public class Wheel {
    private Image image;
    private int val;
    private GameViewer window;

    public Wheel(Image image, GameViewer window){
        this.image = image;
        this.window = window;
    }

    public int getVal(){
        return val;
    }

    public void setVal(int val){
        this.val = val;
    }

    public void draw(Graphics g){
        g.drawImage(image, 0, 140, 700, 600, window);
    }
}
