import javax.swing.*;
import java.awt.*;

public class TriangleFrame extends JFrame {

    public TriangleFrame() {
        setTitle("Sierpinski's Triangle");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new TrianglePanel(this));
        setVisible(true);
    }
}
