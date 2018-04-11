import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MinesweeperPanel extends JPanel {

    public MinesweeperFrame frame;
    Toolkit kit;
    private String[][] display;
    private MineButton[][] gameBoard;
    private String[][] fullField;
    private boolean gameWon = true;

    public MinesweeperPanel(MinesweeperFrame pf) {
        frame = pf;
        kit = Toolkit.getDefaultToolkit();
        display = frame.getModel().getDisplay();
        gameBoard = new MineButton[display.length][display.length];
        fullField = frame.getModel().getFullField();

        setLayout(new GridLayout(display.length, display.length));

        for (int r = 0; r < display.length; r++) {
            for (int c = 0; c < display.length; c++) {
                gameBoard[r][c] = new MineButton(display[r][c], r, c);
                gameBoard[r][c].addMouseListener(new MouseHandler());
                add(gameBoard[r][c], r, c);
            }
        }

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");

        MinesweeperMenuItem newGame = new MinesweeperMenuItem("New");
        newGame.addMouseListener(new MenuButtonHandler());
        menu.add(newGame);

        MinesweeperMenuItem saveGame = new MinesweeperMenuItem("Save");
        saveGame.addMouseListener(new MenuButtonHandler());
        menu.add(saveGame);

        MinesweeperMenuItem loadGame = new MinesweeperMenuItem("Load");
        loadGame.addMouseListener(new MenuButtonHandler());
        menu.add(loadGame);

        MinesweeperMenuItem quitGame = new MinesweeperMenuItem("Quit");
        quitGame.addMouseListener(new MenuButtonHandler());
        menu.add(quitGame);

        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            if (SwingUtilities.isLeftMouseButton(e)) {

                MineButton clicked = (MineButton) e.getSource();

                int y = clicked.getyCords();
                int x = clicked.getxCords();

                display[y][x] = fullField[y][x];
                clicked.setText(display[y][x]);

                if (display[y][x].equals("M")) {

                    int popup = JOptionPane.showConfirmDialog(new JButton(), "You have clicked on a Mine!\n" + "Would you like to play Again?", "Game Ended!", JOptionPane.YES_NO_OPTION);
                    if (popup == 1) {
                        display = fullField;
                        gameWon = false;
                        for (int r = 0; r < display.length; r++) {
                            for (int c = 0; c < display.length; c++) {
                                gameBoard[r][c].setText(display[r][c]);
                            }
                        }

                    } else {
                        frame = new MinesweeperFrame(10);
                    }
                }

                int spotsLeft = 0;

                for (int r = 0; r < display.length; r++) {
                    for (int c = 0; c < display.length; c++) {

                        if (display[r][c].equals("?")) {
                            spotsLeft++;
                        }
                    }
                }

                if (spotsLeft == 0 && gameWon) {
                    int popup = JOptionPane.showConfirmDialog(new JButton(), "You have Won!\n" + "Would you like to play Again?", "Game Ended!", JOptionPane.YES_NO_OPTION);
                    if (popup == 1) {
                        frame.removeAll();
                    } else {
                        frame = new MinesweeperFrame(10);
                    }
                }
            }

            if (SwingUtilities.isRightMouseButton(e)) {

                MineButton clicked = (MineButton) e.getSource();

                int r = clicked.getyCords();
                int c = clicked.getxCords();
                if (display[r][c].equals("?") || display[r][c].equals("F")) {
                    if (display[r][c].equals("F")) {
                        display[r][c] = "?";
                        clicked.setText("?");
                    } else {
                        display[r][c] = "F";
                        clicked.setText("F");
                    }
                }
            }
        }
    }

    private class MenuButtonHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

            MinesweeperMenuItem clicked = (MinesweeperMenuItem) e.getSource();
            String test = clicked.getlable();
            System.out.println(clicked.getlable());

            if (test.equals("Quit")) {

                System.exit(0);
            }
            if (test.equals("Load")) {

                JFileChooser fileChooser = new JFileChooser();
                int val = fileChooser.showOpenDialog(MinesweeperPanel.this);

                if (val == JFileChooser.APPROVE_OPTION){

                    try {
                        File file = fileChooser.getSelectedFile();
                        int length = frame.getModel().loadGame(file);

                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line = reader.readLine();
                        String lineTwo = reader.readLine();

                        String[][] newdisp = new String[length][length];
                        int count = 0;
                        for (int r = 0; r < newdisp.length; r++){
                            for (int c = 0; c < newdisp.length; c++){

                                newdisp[r][c] = Character.toString(line.charAt(count));
                                count++;
                            }
                        }

                        String[][] newfield = new String[length][length];
                        count = 0;
                        for (int r = 0; r < newfield.length; r++){
                            for (int c = 0; c < newfield.length; c++){

                                newfield[r][c] = Character.toString(lineTwo.charAt(count));
                                count++;
                            }
                        }

                        for (int r = 0; r < display.length; r++) {
                            for (int c = 0; c < display.length; c++) {
                                gameBoard[r][c].setText(display[r][c]);
                            }
                        }

                        new MinesweeperFrame(length, newdisp, newfield);

                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
            if (test.equals("Save")) {

                String name = JOptionPane.showInputDialog("Enter Save Name:");
                File file = new File(name);

                frame.getModel().saveGame(file, display, fullField, frame.getModel().getDifficalty());
            }
            if (test.equals("New")) {

                Object[] options = {"Easy", "Medium", "Hard"};

                int diff = JOptionPane.showOptionDialog(frame, "Choose difficalty", "New Game", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
                if (diff == 0){

                    System.out.println(0);
                    new MinesweeperFrame(10);
                }
                if (diff == 1){

                    new MinesweeperFrame(15);
                }
                if (diff == 2){

                    new MinesweeperFrame(20);
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }
    }
}
