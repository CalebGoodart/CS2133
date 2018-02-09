import java.math.BigDecimal;

public class Ramanujan {

    public getRam(int n){

    }

    public static void main(String[] args){
        int input = Integer.parseInt(args[0]);
        double gregPi = gregFoum(input) * 4;
        double percentError = ((Math.PI-gregPi)/Math.PI) * 100;

        System.out.println("Pi according to Gregory series: " + gregPi);
        System.out.println("This differs from Java's value by " + percentError);
    }
}
