import javax.swing.*;

public class MineButton extends JButton {

    private String cords;
    private int xCords;
    private int yCords;

    public MineButton(String label, String fieldCord, int r, int c){

        super(label);
        cords = fieldCord;
        xCords = c;
        yCords = r;
    }

    public int getxCords() {
        return xCords;
    }

    public int getyCords(){
        return yCords;
    }

    @Override
    protected String paramString() {
        return cords;
    }
}
