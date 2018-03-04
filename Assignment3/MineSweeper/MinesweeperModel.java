import java.util.*;

public class MinesweeperModel {

    private String[][] fieldCords;
    private String[][] mineField;
    private String[][] fullField;
    private String[][] display;

    private String[] mineLocation;

    public MinesweeperModel() {

        fieldCords = new String[10][10];
        setFieldCords(fieldCords);
        mineLocation = new String[10];
        setMineLocation();
        mineField = new String[10][10];
        setMineField(mineField);
        fullField = new String[10][10];
        setFullField(fullField);
        display = new String[10][10];
        setDisplay(display);
    }

    private void setFieldCords(String[][] fieldCords){

        for (int r = 0; r < fieldCords.length; r++){
            for (int c = 0; c < fieldCords.length; c++){

                if (fieldCords[r] == fieldCords[0]){
                    fieldCords[r][c] = "A" + c;
                }
                if (fieldCords[r] == fieldCords[1]){
                    fieldCords[r][c] = "B" + c;
                }
                if (fieldCords[r] == fieldCords[2]){
                    fieldCords[r][c] = "C" + c;
                }
                if (fieldCords[r] == fieldCords[3]){
                    fieldCords[r][c] = "D" + c;
                }
                if (fieldCords[r] == fieldCords[4]){
                    fieldCords[r][c] = "E" + c;
                }
                if (fieldCords[r] == fieldCords[5]){
                    fieldCords[r][c] = "F" + c;
                }
                if (fieldCords[r] == fieldCords[6]){
                    fieldCords[r][c] = "G" + c;
                }
                if (fieldCords[r] == fieldCords[7]){
                    fieldCords[r][c] = "H" + c;
                }
                if (fieldCords[r] == fieldCords[8]){
                    fieldCords[r][c] = "I" + c;
                }
                if (fieldCords[r] == fieldCords[9]){
                    fieldCords[r][c] = "J" + c;
                }
            }
        }
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

            String rn = Integer.toString((int)(100 * new Random().nextDouble()));

                mineLocation[i] = rn;
        }

        for (int i = 0; i < mineLocation.length; i++){
            for (int j = 0; j < mineLocation.length; j++){


            }
        }
    }

    private void setFullField(String[][] fullField){

        for (int r = 0; r < fullField.length; r++){
            for (int c = 0; c < fullField.length; c++){

                fullField[r][c] = detect(r, c, "M");
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


    public String[][] getFieldCords(){
        return fieldCords;
    }

    public String[][] getMineField(){
        return mineField;
    }

    public String[][] getFullField() {
        return fullField;
    }

    public String[][] getDisplay(){
        return display;
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

    public static void main(String[] args){
        MinesweeperModel model = new MinesweeperModel();

        String[][] fieldCords = model.getFieldCords();
        String[][] mineField = model.getMineField();
        String[][] fullField = model.getFullField();
        String[][] display = model.getDisplay();

        for (int r = 0; r < fieldCords.length; r++){
            for (int c = 0; c < fieldCords.length; c++){
                    System.out.print(fieldCords[r][c]);
            }
            System.out.println();
        }

        System.out.println();

        for (int r = 0; r < mineField.length; r++){
            for (int c = 0; c < mineField.length; c++){

                System.out.print(mineField[r][c]);
            }
            System.out.println();
        }

        System.out.println();

        for (int r = 0; r < fullField.length; r++){
            for (int c = 0; c < fullField.length; c++){

                System.out.print(fullField[r][c]);
            }
            System.out.println();
        }

        System.out.println();

        for (int r = 0; r < display.length; r++){
            for (int c = 0; c < display.length; c++){

                System.out.print(display[r][c]);
            }
            System.out.println();
        }

        Boolean run = true;
        while (run){

            Scanner scan = new Scanner(System.in);

            for (int r = 0; r < display.length; r++){
                for (int c = 0; c < display.length; c++){

                    System.out.print(display[r][c]);
                }
                System.out.println();
            }

            String input = scan.next();

            for (int r = 0; r < fullField.length; r++){
                for (int c = 0; c < fullField.length; c++){

                    if (input.equals(fieldCords[r][c])){
                        if (fullField[r][c].equals("M")){
                            run = false;
                        }else {
                            display[r][c] = fullField[r][c];
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}
