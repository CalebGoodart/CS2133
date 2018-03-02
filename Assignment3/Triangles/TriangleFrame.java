import javax.swing.*;
import java.awt.*;

public class TriangleFrame extends JFrame {

    public TriangleFrame() {
        setTitle("Sierpinski's Triangle");
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new TrianglePanel());
        setVisible(true);
    }
}
