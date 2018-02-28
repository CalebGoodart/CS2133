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
        //g.drawRoundRect(kit.getcreenSize().width/2, kit.getScreenSize().height/4,125, 300, 30, 30);
        g.drawLine(CENTERX - 30, CENTERY + 150, CENTERX + 80, CENTERY + 150);
        g.drawArc(CENTERX, CENTERY, 50, 50, 0, 90);
    }
}
