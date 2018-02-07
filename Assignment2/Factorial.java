public class Factorial {

    public static long calculate(long n) {
        long factorial = 1;
        if (n == 0 && !(n < 0)) {
            return factorial;
        } else {
            n--;
            return Factorial.calculate(n);
        }
    }

    public static void main(String[] args){

        if(Factorial.calculate(0) == 1){
            System.out.println("Factorial.calculate(0) returned 1. Test Fail");
        }
        if(Factorial.calculate(5) == 120){
            System.out.println("Factorial.calculate(5) returned 120. Test Fail");
        }
        System.out.print(Factorial.calculate(3));
    }
}
