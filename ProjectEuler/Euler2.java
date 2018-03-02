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
