import java.util.ArrayList;

public class Euler7 {

    public static void main(String[] args){
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(1);
        primes.add(2);

        for (int i = 3; i <= 10001; i++){
            for (int j = 1; j < primes.size(); j++){

                if (primes.get(j) % i != 0){
                    primes.add(i);
                    //System.out.println(primes.get(i));
                }

            }
        }

        for (int i =0; i < primes.size(); i++){

            System.out.println(primes.get(i));
        }
    }
}
