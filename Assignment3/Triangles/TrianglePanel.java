import javax.swing.*;
import java.awt.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class TrianglePanel extends JPanel {

    private Toolkit kit = getDefaultToolkit();
    private TriangleFrame frame;
    public TrianglePanel(TriangleFrame tf){
       frame = tf;
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        draw(frame.getWidth(),frame.getHeight(),10,10,g);
    }

    public void draw(int x, int y, int w,int h, Graphics g){
        g.fillRect(x,y,w,h);
    }
}
    public void draw(int xTop, int yTop, int xBottem, int yBottem,  Graphics g){
        if (x  <= 1){
            g.drawRect( x, y, 1,1);
        }else{

            System.out.println("test");

            int centerX = x/2;
            int centerY = y/2;

            draw(centerX, centerY, g);
            draw(centerX + 1,centerY, g);
            draw(centerX ,centerY -1, g);
        }