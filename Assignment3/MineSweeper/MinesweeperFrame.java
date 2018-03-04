import javax.swing.*;

public class MinesweeperFrame extends JFrame {

        private MinesweeperModel model;

        public MinesweeperFrame() {
            setTitle("Minesweeper");
            setSize(1000, 1000);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            model = new MinesweeperModel();
            add(new MinesweeperPanel(this));
            setVisible(true);
        }

        public MinesweeperModel getModel() {
            return model;
        }
}
