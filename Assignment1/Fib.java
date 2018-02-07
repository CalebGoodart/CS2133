import java.util.ArrayList;

public class Fib {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        ArrayList<Integer> fibs = new ArrayList<>();
        fibs.add(1);
        fibs.add(1);

        for (int i = 1; i < n -1; i++){
            fibs.add(fibs.get(i-1) + fibs.get(i));
        }
        System.out.println(fibs.get(fibs.size()-1));
    }
}
