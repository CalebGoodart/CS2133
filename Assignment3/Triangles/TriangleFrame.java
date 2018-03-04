import javax.swing.*;

public class TriangleFrame extends JFrame {

    public TriangleFrame() {
        setTitle("Sierpinski's Triangle");
        setSize(512, 512);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new TrianglePanel(this));
        setVisible(true);
    }
}
