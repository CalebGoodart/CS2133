import javax.swing.*;

public class TriangleFrame extends JFrame {

    public TriangleFrame() {
        setTitle("Sierpinski's Triangle");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new TrianglePanel(this));
        setVisible(true);
    }
}
