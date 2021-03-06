import java.util.ArrayList;

public class Euler2 {

    public static void main(String[] args){
        ArrayList<Integer> fibs = new ArrayList<>();
        fibs.add(1);
        fibs.add(1);
        int sum = 0;
        for (int i = 1; fibs.get(i-1) < 4000000; i++){
            fibs.add(fibs.get(i-1) + fibs.get(i));
            if (fibs.get(i)%2 == 0){
                sum += fibs.get(i);
            }
        }
        System.out.println(sum);
    }
}

/*
Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 By starting with 1 and 2, the first 10 terms will be:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

By considering the terms in the Fibonacci sequence whose values do not exceed
four million, find the sum of the even-valued terms.
*/
