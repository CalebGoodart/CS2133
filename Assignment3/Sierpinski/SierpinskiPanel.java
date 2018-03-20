import javax.swing.*;
import java.awt.*;

public class SierpinskiPanel extends JPanel {

    private SierpinskiFrame frame;
    Toolkit kit;
    int MAX_X;
    int MAX_Y;

    public SierpinskiPanel(SierpinskiFrame pf) {
        setLayout(new GridLayout());
        frame = pf;
        kit = Toolkit.getDefaultToolkit();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = frame.getWidth();
        int y = frame.getHeight();
        MAX_X = frame.getWidth();
        MAX_Y = frame.getHeight();
        //g.drawRect((int).5,399,10,10);
        g.setColor(Color.black);
        if (x <= y){
            g.fillRect(0,0,x,x);
            g.setColor(Color.white);
            draw(0, 0, x, x, g);
        }else {
            g.fillRect(0,0,y,y);
            g.setColor(Color.white);
            draw(0, 0, y, y, g);
        }
    }

    public void draw(int x0, int y0, int width, int height, Graphics g){

        if (width < 1 || height < 1){
            return;
        }
        g.fillRect(x0, y0, width/4, height / 2);
        g.fillRect(( x0 + width * 3 / 4), y0, width/4, height/2);
        
        draw(x0, y0 + height/2, width/2, height/2, g);
        draw(x0 + width/2, y0 + height/2, width/2, height/2, g);
        draw(x0 + width/4, y0, width/2, height/2, g);
    }
}
