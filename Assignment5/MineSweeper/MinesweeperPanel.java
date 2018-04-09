import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MinesweeperPanel extends JPanel {

    private MinesweeperFrame frame;
    Toolkit kit;
    private String[][] display;
    private String[][] fieldCord;
    private MineButton[][] gameBoard;
    private String[][] fullField;


    public MinesweeperPanel(MinesweeperFrame pf) {
        frame = pf;
        kit = Toolkit.getDefaultToolkit();
        display = frame.getModel().getDisplay();
        fieldCord =frame.getModel().getFieldCords();
        gameBoard = new MineButton[10][10];
        fullField = frame.getModel().getFullField();

        setLayout(new GridLayout(10,10));

        for (int r = 0; r < display.length; r++){
            for (int c = 0; c < display.length; c++){
                gameBoard[r][c] = new MineButton(display[r][c], r, c);
                gameBoard[r][c].addMouseListener(new MouseHandler());
                gameBoard[r][c].addActionListener(new ButtonHandler());
                add(gameBoard[r][c],r,c);
            }
        }
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            if (SwingUtilities.isLeftMouseButton(e)){

                MineButton clicked = (MineButton)e.getSource();

                int y = clicked.getyCords();
                int x = clicked.getxCords();

                display[y][x] = fullField[y][x];
                clicked.setText(display[y][x]);

                if (display[y][x].equals("M")){

                    int popup = JOptionPane.showConfirmDialog(new JButton(),"You have clicked on a Mine!\n"+"Would you like to play Again?",  "Game Ended!", JOptionPane.YES_NO_OPTION);
                    if (popup == 1){
                        frame.dispatchEvent( new WindowEvent(frame, WindowEvent.WINDOW_CLOSED));
                    }else {
                        new MinesweeperFrame();
                        frame.dispatchEvent( new WindowEvent(frame, WindowEvent.WINDOW_CLOSED));
                    }
                }

                int spotsLeft = 0;

                for (int r = 0; r < display.length; r++){
                    for (int c = 0; c < display.length; c++){

                        if (display[r][c].equals("?")){
                            spotsLeft++;
                        }
                    }
                }

                if (spotsLeft == 0){
                    int popup = JOptionPane.showConfirmDialog(new JButton(),"You have Won!\n"+"Would you like to play Again?",  "Game Ended!", JOptionPane.YES_NO_OPTION);
                    if (popup == 1){
                        frame.dispatchEvent( new WindowEvent(frame, WindowEvent.WINDOW_CLOSED));
                    }else {
                        new MinesweeperFrame();
                        frame.dispatchEvent( new WindowEvent(frame, WindowEvent.WINDOW_CLOSED));
                    }
                }
            }

            if (SwingUtilities.isRightMouseButton(e)){

                MineButton clicked = (MineButton)e.getSource();

                int r = clicked.getyCords();
                int c = clicked.getxCords();
                if (display[r][c].equals("?") || display[r][c].equals("F")){
                    if (display[r][c].equals("F")){
                        display[r][c] = "?";
                        clicked.setText("?");
                    }else {
                        display[r][c] = "F";
                        clicked.setText("F");
                    }
                }
            }

        }
    }
    private class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
