
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

        if ( n == 1){
            return 1;
        }else if (n == 2){
            return 1;
        }else{
            return fibRecur(n - 1) + fibRecur( n - 2);
        }
    }

    public static void main(String[] args){

        long fibIter = System.currentTimeMillis();
        System.out.println(fibIter(40));
        System.out.println(System.currentTimeMillis() - fibIter);

        long fibRecur = System.currentTimeMillis();
        System.out.println(fibRecur(40));
        System.out.println(System.currentTimeMillis() - fibRecur);
    }
}
