public class Euler6 {

    public static void main(String[] args){

        int squares = 0;
        double sums = 0;
        double total = 0;

        for (int i = 1; i <= 100; i++){

            squares += Math.pow(i, 2);
        }

        for (int i = 1; i <= 100; i++){

            sums += i;
        }

        sums = Math.pow(sums, 2);

        total = sums - squares;

        System.out.println((int)total);

    }
}
