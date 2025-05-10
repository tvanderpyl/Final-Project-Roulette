import java.awt.*;

public class Wheel {
    private Image image;
    private int val;
    private GameViewer window;
    // 0 = red     1 = black
    private int color;

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

    public int getColor(){
        return color;
    }

    public void setColor(int num){
        this.color = num;
    }

    public void draw(Graphics g){
        g.drawImage(image, 0, 140, 700, 600, window);
    }
}
