import javax.swing.*;
import java.awt.*;

public class TriangleFrame extends JFrame {

    private TriangleModel model;

    public TriangleFrame() {
        setTitle("Sierpinski's Triangle");
        setSize(500,500);
        //setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new TrianglePanel(this));
        setVisible(true);
    }
}
