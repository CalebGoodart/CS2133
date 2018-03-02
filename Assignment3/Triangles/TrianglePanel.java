import javax.swing.*;
import java.awt.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class TrianglePanel extends JPanel {

    private TriangleFrame frame;
    Toolkit kit;

    public TrianglePanel(TriangleFrame pf) {
        frame = pf;
        kit = Toolkit.getDefaultToolkit();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        TriangleModel model = frame.getModel();

        if (frame.getWidth()<frame.getHeight()){
            draw(0,0,frame.getWidth(),frame.getWidth(),g);
        }else {
            draw(0,0,frame.getHeight(),frame.getHeight(),g);
        }

    }

    public void draw(int x, int y,int x0, int y0, Graphics g){
        int x1 = x;
        int y1 = y;
        int x2 = x0;
        int y2 = y0;

        if (x2==1){
           g.drawRect(x2,y2,10,10);
        }else{

            draw(x1,y1,x2/2,y2/2,g);
            draw(x2/2,y2/2,x2,y2,g);
            draw(x2/4,y1,(3 * x2)/4,y2/2,g);
        }
    }
}