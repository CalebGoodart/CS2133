import javax.swing.*;
import java.awt.*;

public class BrowserFrame extends JFrame{

    public BrowserFrame(){

        setTitle("Browser");
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width/2, Toolkit.getDefaultToolkit().getScreenSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new BrowserPanel());
        setVisible(true);
    }

}
