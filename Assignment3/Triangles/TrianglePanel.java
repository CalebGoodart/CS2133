import javax.swing.*;
import java.awt.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class TrianglePanel extends JPanel {

    private TriangleFrame frame;
    Toolkit kit;

    public TrianglePanel(TriangleFrame pf) {
        frame = pf;
        kit = Toolkit.getDefaultToolkit();

        System.out.println(frame.getWidth() + " " + frame.getHeight());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //g.drawRect(1,200,200,200);
            draw(0,0,frame.getWidth(),frame.getHeight(),g);


    }

    public void draw(int x, int y,int x0, int y0, Graphics g){

        if ((x0)==1){
           g.fillRect(x0 - 1,y0-35,10,10);
        }else if (x0 == 2){
            g.fillRect(x0 + 9 ,y0-35,10,10);
        }
        else{
            draw(x,y,x0/2,y0,g);
            draw(x, y,x0 + 1,y0,g);
            //draw(x/4,y,(3 * x)/4,y/2,g);
        }
    }
}