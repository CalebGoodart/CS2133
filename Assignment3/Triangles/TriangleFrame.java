import javax.swing.*;
import java.awt.*;

public class TriangleFrame extends JFrame {

    private TriangleModel model;

    public TriangleFrame() {
        setTitle("Sierpinski's Triangle");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model = new TriangleModel();
        add(new TrianglePanel(this));
        setVisible(true);
    }

    public TriangleModel getModel() {
        return model;
    }
}
