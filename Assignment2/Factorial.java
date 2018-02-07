public class Factorial {

    public static long calculate(long n) {
        if (n  <  0 || n > 20){
            System.out.println("ERROR");
            return n;
        } else if (n == 0 ) {
            return 1;
        } else {

            return n * Factorial.calculate(n - 1);
        }
    }

    public static void main(String[] args){

        if(Factorial.calculate(0) == 1){
            System.out.println("Factorial.calculate(0) returned 1. Test Passed");
        }
        if(Factorial.calculate(5) == 120){
            System.out.println("Factorial.calculate(5) returned 120. Test Passed");
        }
    }
}
