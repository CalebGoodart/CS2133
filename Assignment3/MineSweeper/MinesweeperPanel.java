import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MinesweeperPanel extends JPanel {

    private MinesweeperFrame frame;
    Toolkit kit;

    public MinesweeperPanel(MinesweeperFrame pf) {
        frame = pf;
        kit = Toolkit.getDefaultToolkit();

        setLayout(new GridLayout());

        addMouseMotionListener(new MouseHandler());

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        MinesweeperModel model = frame.getModel();
    }

    private class MouseHandler extends MouseMotionAdapter {

        
    }

}
