import javax.swing.*;

public class MineButton extends JButton {

    private int xCords;
    private int yCords;

    public MineButton(String label, int r, int c){

        super(label);
        xCords = c;
        yCords = r;
    }

    public int getxCords() {
        return xCords;
    }

    public int getyCords(){
        return yCords;
    }

}
