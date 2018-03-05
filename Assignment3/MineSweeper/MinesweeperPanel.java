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
                gameBoard[r][c] = new MineButton(display[r][c], fieldCord[r][c], r, c);
                gameBoard[r][c].addMouseListener(new MouseHandler());
                gameBoard[r][c].addActionListener(new ButtonHandler());
                add(gameBoard[r][c],r,c);
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        MinesweeperModel model = frame.getModel();
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            if (SwingUtilities.isLeftMouseButton(e)){
                System.out.println("Clicked Left!");
                System.out.println(e.getX() + " " + e.getY() + " " + e);

                MineButton clicked = (MineButton)e.getSource();

                int r = clicked.getyCords();
                int c = clicked.getxCords();
                if (fullField[r][c].equals("M")){

                    //JOptionPane popup = new JOptionPane( "You have clicked on a Mine!\n"+"Would you like to play Again?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
                    int x = JOptionPane.showConfirmDialog(new JButton(),"You have clicked on a Mine!\n"+"Would you like to play Again?",  "Game Ended!", JOptionPane.YES_NO_OPTION);
                    if (x == 1){
                        frame.dispatchEvent( new WindowEvent(frame, WindowEvent.WINDOW_CLOSED));
                    }else {
                        new MinesweeperFrame();
                        frame.dispatchEvent( new WindowEvent(frame, WindowEvent.WINDOW_CLOSED));

                    }

                    //new MinesweeperFrame();
                }

                display[r][c] = fullField[r][c];
                clicked.setText(display[r][c]);
            }


            if (SwingUtilities.isRightMouseButton(e)){

                System.out.println("Clicked Right!");
                System.out.println(e.getX() + " " + e.getY() + " " + e.getSource());

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
            System.out.println("Button Pressed!" + e);
            addMouseListener(new MouseHandler());

        }
    }

}
