import javax.swing.*;

public class SierpinskiFrame extends JFrame {

    public SierpinskiFrame() {
        setTitle("Sierpinski's Triangle");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new SierpinskiPanel(this));
        setVisible(true);
    }
}
