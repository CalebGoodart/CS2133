import java.io.*;
import java.util.*;

public class MinesweeperModel {

    private String[][] mineField;
    private String[][] fullField;
    private String[][] display;
    private String[] mineLocation;
    private int difficalty;

    public MinesweeperModel(int n) {

        difficalty = n;
        mineLocation = new String[n];
        setMineLocation();
        mineField = new String[n][n];
        setMineField(mineField);
        fullField = new String[n][n];
        setFullField(fullField);
        display = new String[n][n];
        setDisplay(display);
    }

    public MinesweeperModel(int n, String[][] disp, String[][] field){

        difficalty = n;
        display = disp;
        fullField = field;
    }

    public void setDifficalty(int diff){
        difficalty = diff;
    }

    private void setMineField(String[][] mineField){

        int count = 0;
        for (int r = 0; r < mineField.length; r++){
            for (int c = 0; c < mineField.length; c++){

                mineField[r][c] = Integer.toString(count);
                count++;
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

    private void setMineLocation(){

        for (int i = 0; i < mineLocation.length; i++){

            String rn = Integer.toString((int)((difficalty * difficalty) * new Random().nextDouble()));

                mineLocation[i] = rn;
        }
    }

    public void setFullField(String[][] fullField){

        for (int r = 0; r < fullField.length; r++){
            for (int c = 0; c < fullField.length; c++){

                fullField[r][c] = detect(r, c, "M");
            }
        }
    }

    public void setDisplay(String[][] display){

        for (int r = 0; r < display.length; r++){
            for (int c = 0; c < display.length; c++){

                display[r][c] = "?";
            }
        }
    }

    public void saveGame(File file, String[][] disp, String[][] field, int diff){

        try {

            FileWriter fileWriter = new FileWriter(file);


            for (int r = 0; r < disp.length; r++) {
                for (int c = 0; c < disp.length; c++) {
                    fileWriter.write(disp[r][c]);
                }
            }
            fileWriter.write("\n");

            for (int r = 0; r < field.length; r++) {
                for (int c = 0; c < field.length; c++) {
                    fileWriter.write(field[r][c]);
                }
            }
            fileWriter.write("\n");
            fileWriter.write(diff);
            fileWriter.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int loadGame(File file){

        int diff = 0;
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                String lineTwo = reader.readLine();
                diff = reader.read();
/*
                setDifficalty(diff);

                int count = 0;
                for (int r = 0; r < display.length; r++){
                    for (int c = 0; c < display.length; c++){

                        display[r][c] = Character.toString(line.charAt(count));
                        count++;
                    }
                }

                count = 0;
                for (int r = 0; r < fullField.length; r++){
                    for (int c = 0; c < fullField.length; c++){

                        fullField[r][c] = Character.toString(lineTwo.charAt(count));
                        count++;
                    }
                }

                for (int r = 0; r < display.length; r++){
                    for (int c = 0; c < display.length; c++){

                        System.out.print(display[r][c]);
                    }
                    System.out.println();
                }
*/
                return diff;

            }catch (Exception ex){
                ex.printStackTrace();
            }

            return diff;
        }

    public String[][] getFullField() {
        return fullField;
    }

    public String[][] getDisplay(){
        return display;
    }

    public int getDifficalty(){
        return difficalty;
    }

    public String detect(int r, int c, String s){

        int mineCount = 0;
        if (mineField[r][c].equals(s)){
            return s;
        }else {

            if (r == 0 && c == 0){
                if (mineField[r + 1][c].equals(s)){
                    mineCount++;
                }
                if (mineField[r + 1][c + 1].equals(s)){
                    mineCount++;
                }
                if (mineField[r][c + 1].equals(s)){
                    mineCount++;
                }
            }else if (r == fullField.length - 1 && c == fullField.length - 1){

                if (mineField[r - 1][c].equals(s)){
                    mineCount++;
                }
                if (mineField[r - 1][c - 1].equals(s)){
                    mineCount++;
                }
                if (mineField[r][c - 1].equals(s)){
                    mineCount++;
                }
            }else if (r == 0 && c == fullField.length - 1) {

                if (mineField[r + 1][c].equals(s)){
                    mineCount++;
                }
                if (mineField[r][c - 1].equals(s)){
                    mineCount++;
                }
                if (mineField[r + 1][c - 1].equals(s)){
                    mineCount++;
                }
            }else if (r == fullField.length - 1 && c == 0){

                if (mineField[r][c + 1].equals(s)){
                    mineCount++;
                }
                if (mineField[r -1][c + 1].equals(s)){
                    mineCount++;
                }
                if (mineField[r - 1][c].equals(s)){
                    mineCount++;
                }
            }else if (r == 0) {
                    if (mineField[r + 1][c].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r + 1][c + 1].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r][c + 1].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r][c - 1].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r + 1][c - 1].equals(s)) {
                        mineCount++;
                    }
                } else if (c == 0) {
                    if (mineField[r + 1][c].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r + 1][c + 1].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r][c + 1].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r - 1][c + 1].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r - 1][c].equals(s)) {
                        mineCount++;
                    }

                } else if (r == fullField.length - 1) {

                    if (mineField[r][c + 1].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r - 1][c + 1].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r - 1][c].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r - 1][c - 1].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r][c - 1].equals(s)) {
                        mineCount++;
                    }
                } else if (c == fullField.length - 1) {

                    if (mineField[r + 1][c].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r - 1][c].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r - 1][c - 1].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r][c - 1].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r + 1][c - 1].equals(s)) {
                        mineCount++;
                    }
                } else {
                    if (mineField[r + 1][c].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r + 1][c + 1].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r][c + 1].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r - 1][c + 1].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r - 1][c].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r - 1][c - 1].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r][c - 1].equals(s)) {
                        mineCount++;
                    }
                    if (mineField[r + 1][c - 1].equals(s)) {
                        mineCount++;
                    }
            }
            return Integer.toString(mineCount);
        }
    }
}
