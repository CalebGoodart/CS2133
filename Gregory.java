public class Gregory {

    public static double gregFoum(int input){
        double gregOutput = 0;

        for (int i = 1; i <= input; i++ ) {
            gregOutput+=((Math.pow(-1, i + 1)) / ((2 * i) - 1));
        }
        return gregOutput;
    }

    public static void main(String[] args){
        int input = Integer.parseInt(args[0]);
        double gregPi = gregFoum(input) * 4;
        double percentError = ((Math.PI-gregPi)/Math.PI) * 100;

        System.out.println("Pi according to Gregory series: " + gregPi);
        System.out.println("This differs from Java's value by " + percentError);
    }
}
