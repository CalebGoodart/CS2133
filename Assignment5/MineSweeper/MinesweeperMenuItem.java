import javax.swing.*;

public class MinesweeperMenuItem extends JMenuItem{

    private String title;
    public MinesweeperMenuItem(String lable){

        super(lable);
        title = lable;
    }

    public String getlable(){

        return title;
    }
}
