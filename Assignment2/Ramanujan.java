
public class Ramanujan {

    public static double getRam(int input){

        double remOutput = 0;

        for (int i = 0; i <= input; i++ ) {
            remOutput+=((Factorial.calculate(4*i) * (1103 + (26390 * i))) / (Math.pow( Factorial.calculate(i), 4) * Math.pow(396, (4 * i))));
            System.out.println(remOutput);
        }
        return 1/( ((2 * Math.sqrt(2)) / Math.pow( 99, 2)) * remOutput);
    }

    public static void main(String[] args){
        int input = Integer.parseInt(args[0]);
        double ramPI = Ramanujan.getRam( input );
        System.out.println("Pi according to Ramanujan series: " + ramPI);
        System.out.println("This differs from Java's value by " + ((Math.PI-ramPI)/Math.PI) * 100);
    }
}
