import javax.swing.*;

public class MinesweeperFrame extends JFrame{

        private MinesweeperModel model;

        public MinesweeperFrame(int n) {
            setTitle("Minesweeper");
            setSize(512, 512);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            model = new MinesweeperModel(n);
            add(new MinesweeperPanel(this));
            setVisible(true);
        }

        public MinesweeperModel getModel() {
            return model;
        }

        public MinesweeperFrame(int n, String[][] disp, String[][] field){
            setTitle("Minesweeper");
            setSize(512, 512);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            model = new MinesweeperModel(n, disp, field);
            add(new MinesweeperPanel(this));
            setVisible(true);
        }
}
