import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.swing.*;
import java.awt.*;

public class TrianglePanel extends JPanel {

    private TriangleFrame frame;
    Toolkit kit;

    public TrianglePanel(TriangleFrame pf) {
        setLayout(new GridLayout());
        frame = pf;
        kit = Toolkit.getDefaultToolkit();

        System.out.println(frame.getWidth() + " " + frame.getHeight());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = frame.getWidth();
        int y = frame.getHeight();
        //g.drawRect((int).5,399,10,10);

        if (x<=y){
            draw( x,x, x, x, x, 0,  g);
        }else {
            draw( y,x, y, y, y, 0,  g);
        }
        System.out.println(frame.getWidth() + " " + frame.getHeight());

    }

    public void draw(int r, int x0, int x1, int y0, int y1, int y2, Graphics g){

        System.out.printf("%d, %d, %d, %d || %d, %d  \n", x0, x1, y0, y1, r, y2);
        if (x1 - x0/2 == 1) {
            System.out.println("PRINT");
            g.drawRect(x1, y1 - y0, 1, 1);
        }else {
            System.out.println("ONE");
            draw(r, x0 / 2, x1 / 2, y0 / 2, y1, y2 + 1, g);
            System.out.println("TWO");
            draw(r,x1/2, x1, y0, y1, y2 - 1, g);
            //draw( g);
        }
    }
}