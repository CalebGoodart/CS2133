import javax.swing.*;
import java.awt.*;

public class TrianglePanel extends JPanel {

    private TriangleFrame frame;
    Toolkit kit;
    int MAX_X;
    int MAX_Y;

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
        MAX_X = frame.getWidth();
        MAX_Y = frame.getHeight();
        //g.drawRect((int).5,399,10,10);
        g.setColor(Color.black);
        if (x <= y){
            g.fillRect(0,0,x,x);
            g.setColor(Color.white);
            draw2(0, 0, x, x, g);
        }else {
            g.fillRect(0,0,y,y);
            g.setColor(Color.white);
            draw2(0, 0, y, y, g);
        }
        System.out.println(frame.getWidth() + " " + frame.getHeight());

    }

    public void draw(int x0, int y0, int x1, int y1, Graphics g){

        System.out.printf("%d, %d, %d, %d\n", x0, y0, x1, y1);

        g.fillRect(x0, y0, (x1 - x0)/4, (y1 - y0) / 2);
        g.fillRect(((x1 - x0)/4) * 3, y0, (x1 - x0)/4, (y1 - y0)/2);
        System.out.println("PRINT");

        int x2 =x0;
        int y2 =y0 + (y1 - y0) / 2;
        int x3 =(x1 - x0) /2;
        int y3 =y1;

        if (y2 == y0 || x3 == 0){
            return;
        }
        draw(x2, y2, x3, y3, g);

            //draw(x1/2, y1/2, x1,y1,g);
            //draw(x1/4, y0, (x1/4) * 3, y1/2, g);
    }

    public void draw2(int x0, int y0, int width, int height, Graphics g){

        System.out.printf("%d, %d, %d, %d\n", x0, y0, width, height);
        if (width < 1 || height < 1){
            return;
        }
        g.fillRect(x0, y0, width/4, height / 2);
        g.fillRect(( x0 + width * 3 / 4), y0, width/4, height/2);
        System.out.println("PRINT");

        draw2(x0, y0 + height/2, width/2, height/2, g);
        draw2(x0 + width/2, y0 + height/2, width/2, height/2, g);
        draw2(x0 + width/4, y0, width/2, height/2, g);

        //draw(x1/2, y1/2, x1,y1,g);
        //draw(x1/4, y0, (x1/4) * 3, y1/2, g);
    }
}