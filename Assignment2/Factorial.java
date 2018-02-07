public class Factorial {

    public static long calculate(long n){
        if(!(n < 0 && n > 20)){
            return n;
        }else{
            n=n*(n-1);
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
    }
}
