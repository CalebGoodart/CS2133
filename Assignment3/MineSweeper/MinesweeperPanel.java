import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MinesweeperPanel extends JPanel {

    private MinesweeperFrame frame;
    Toolkit kit;

    public MinesweeperPanel(MinesweeperFrame pf) {
        frame = pf;
        kit = Toolkit.getDefaultToolkit();
        addMouseMotionListener(new MouseHandler());
        Timer timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                repaint();
                kit.sync();
            }
        });
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        MinesweeperModel model = frame.getModel();
    }

    private class MouseHandler extends MouseMotionAdapter {

    }

}
