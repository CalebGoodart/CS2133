import java.math.BigInteger;

public class Euler48 {

    public static void main(String[] args){

        BigInteger sum = BigInteger.ZERO;
        for(int i = 1; i <= 1000; i++){
            BigInteger x = new BigInteger(String.valueOf(i));
            BigInteger pow = x.pow(i);
            sum = sum.add(pow);
        }
        System.out.println(sum);
    }
}

/*
The series, 11 + 22 + 33 + ... + 1010 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
