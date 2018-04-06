import java.math.BigInteger;

public class Euler16 {

    public static void main(String[] args){

        BigInteger big = new BigInteger("2");
        int sums = 0;
        big = big.pow(1000);

        for (int i = 0; i < big.toString().length(); i++){

            sums += Integer.parseInt(String.valueOf(big.toString().charAt(i)));
        }

        System.out.println(sums);
    }
}
