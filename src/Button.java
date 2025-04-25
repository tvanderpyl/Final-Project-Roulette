import java.awt.*;

public class Button{
    private GameViewer window;
    private Image image;
    private int x;
    private int y;
    private int width;
    private int height;

    public Button(GameViewer window, Image image, int x, int y, int width, int height){
        this.window = window;
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g){
        g.drawImage(image, x, y, width, height, window);
    }

    public boolean isClicked(int x, int y) {
        if (x < this.x || y < this.y || y > this.y + height || x > this.x + width){
            return false;
        }
        return true;
    }
}
