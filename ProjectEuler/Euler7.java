import java.util.ArrayList;

public class Euler7 {

    public static void main(String[] args){
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(1);
        primes.add(2);
        boolean test;

        for (int i = 3; primes.size() <= 10001; i++){

            System.out.println(i);
            test =true;
            for (int j = 1; (j < primes.size()) && test; j++){

                if (i % primes.get(j) == 0){
                    test = false;
                }
            }
            if (test){
                primes.add(i);
            }
        }
        System.out.println(primes.get(10001));
    }
}
