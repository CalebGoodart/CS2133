import java.util.ArrayList;

public class FibTest {

    public static int fibIter(int n){
        int[] fibs = new int[n + 1];

        fibs[1] = 1;
        fibs[2] = 1;

        for (int i = 3; i < n + 1; i++){
            fibs[i] = ( fibs[i - 1] + fibs[i -2]);
        }
        return fibs[fibs.length - 1];
    }
    public static int fibRecur(int n){

        return n;
    }

    public static void main(String[] args){
        System.out.println(fibIter(11));
    }
}
