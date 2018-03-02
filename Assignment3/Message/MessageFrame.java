import javax.swing.*;
import java.awt.*;

public class MessageFrame extends JFrame{

    public MessageFrame() {
        setTitle("Message in a bottle");
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MessagePanel());
        setVisible(true);
    }
}
