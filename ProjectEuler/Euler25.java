import java.math.BigInteger;
import java.util.ArrayList;

public class Euler25 {

    public static void main(String[] args){
        ArrayList<BigInteger> fibs = new ArrayList<>();
        fibs.add(BigInteger.valueOf(1));
        fibs.add(BigInteger.valueOf(1));

        for (int i = 1; (fibs.get(i).compareTo(BigInteger.TEN.pow(999))) == -1; i++){

            fibs.add(fibs.get(i).add(fibs.get(i - 1)));
            System.out.println(fibs.get(i));
        }

        System.out.println(fibs.size());
    }
}

