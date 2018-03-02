import javax.swing.*;
import java.awt.*;

import static java.awt.Toolkit.getDefaultToolkit;

public class MessagePanel extends JPanel{

    private Toolkit kit = getDefaultToolkit();

    public MessagePanel(){
        setLayout(new BorderLayout());
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        int CENTERX = kit.getScreenSize().width/2;
        int CENTERY = kit.getScreenSize().height/2;
        g.drawString("*imaginary ship*", CENTERX - 30, CENTERY);
        g.drawLine(CENTERX - 30, CENTERY + 150, CENTERX + 80, CENTERY + 150);
        g.drawArc(CENTERX + 40, CENTERY  - 25, 75, 175, 270, 90);
        g.drawArc(CENTERX - 65, CENTERY  - 25, 75, 175, 180, 90);
        g.drawLine(CENTERX - 65, CENTERY - 100, CENTERX - 65 , CENTERY + 65);
        g.drawLine(CENTERX + 115, CENTERY - 100, CENTERX + 115, CENTERY + 65);
        g.drawArc(CENTERX -35, CENTERY  - 250, 150, 300, 0, 90);
        g.drawArc(CENTERX -65, CENTERY  - 250, 150, 300, 90, 90);
        g.drawLine(CENTERX + 10, CENTERY - 280, CENTERX + 10, CENTERY - 250);
        g.drawLine(CENTERX + 40, CENTERY - 280, CENTERX + 40, CENTERY - 250);
        g.drawLine(CENTERX + 10, CENTERY - 280, CENTERX + 40, CENTERY - 280);
    }
}
