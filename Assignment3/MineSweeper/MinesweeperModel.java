import java.util.*;

public class MinesweeperModel {

    private String[][] gameField;
    private String[][] mineField;
    private String[][] display;

    public MinesweeperModel() {

        gameField = new String[10][10];
        setGameField(gameField);
        mineField = new String[10][10];
        setMineField(mineField);
        display = new String[10][10];
        setDisplay(display);
    }

    private void setGameField( String[][] gameField){

        for (int r = 0; r < gameField.length; r++){
            for (int c = 0; c < gameField.length; c++){

                if (gameField[r] == gameField[0]){
                    gameField[r][c] = "A" + c;
                }
                if (gameField[r] == gameField[1]){
                    gameField[r][c] = "B" + c;
                }
                if (gameField[r] == gameField[2]){
                    gameField[r][c] = "C" + c;
                }
                if (gameField[r] == gameField[3]){
                    gameField[r][c] = "D" + c;
                }
                if (gameField[r] == gameField[4]){
                    gameField[r][c] = "E" + c;
                }
                if (gameField[r] == gameField[5]){
                    gameField[r][c] = "F" + c;
                }
                if (gameField[r] == gameField[6]){
                    gameField[r][c] = "G" + c;
                }
                if (gameField[r] == gameField[7]){
                    gameField[r][c] = "H" + c;
                }
                if (gameField[r] == gameField[8]){
                    gameField[r][c] = "I" + c;
                }
                if (gameField[r] == gameField[9]){
                    gameField[r][c] = "J" + c;
                }
            }
        }
    }

    private void setMineField(String[][] mineField){

        String[] mineLocation = new String[10];
        int count = 0;
        for (int r = 0; r < mineField.length; r++){
            for (int c = 0; c < mineField.length; c++){

                mineField[r][c] = Integer.toString(count);
                count++;
            }
        }

        for (int i = 0; i < mineLocation.length; i++){

            String rn = Integer.toString((int)(100 * new Random().nextDouble()));
            Boolean test = true;

            for (int j = 0; j < i; j++){
                if (mineLocation[j].equals(rn)){
                    test = false;
                }
            }
            if (test) {
                mineLocation[i] = rn;
            }
        }

        for (int r = 0; r < mineField.length; r++){
            for (int c = 0; c < mineField.length; c++){
                for (int i = 0; i < mineLocation.length; i++){
                    if (mineField[r][c].equals(mineLocation[i])){
                        mineField[r][c] = "M";
                    }
                }
            }
        }
    }

    private void setDisplay(String[][] display){

        for (int r = 0; r < display.length; r++){
            for (int c = 0; c < display.length; c++){

                display[r][c] = "?";
            }
        }
    }


    public String[][] getGameField(){
        return gameField;
    }

    public String[][] getMineField(){
        return mineField;
    }

    public String[][] getDisplay(){
        return display;
    }

    public void detect(String xy){

    }

    public static void main(String[] args){
        MinesweeperModel model = new MinesweeperModel();

        String[][] gameField = model.getGameField();
        String[][] mineField = model.getMineField();
        String[][] display = model.getDisplay();

        for (int r = 0; r < gameField.length; r++){
            for (int c = 0; c < gameField.length; c++){
                    System.out.print(gameField[r][c]);
            }
            System.out.println();
        }

        for (int r = 0; r < mineField.length; r++){
            for (int c = 0; c < mineField.length; c++){

                System.out.print(mineField[r][c]);
            }
            System.out.println();
        }

        for (int r = 0; r < display.length; r++){
            for (int c = 0; c < display.length; c++){

                System.out.print(display[r][c]);
            }
            System.out.println();
        }


    }
}
