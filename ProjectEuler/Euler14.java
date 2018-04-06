public class Euler14 {

    private static long test = 0;
    private static long longest = 0;
    private static long number = 0;

    public static void check(long num, long index, long start){

        if (num == 1) {
            test = index;

            if (longest < test){
                longest = test;
                number = start;
            }
        }else {
            if (num % 2 == 0) {
                check(num / 2, index + 1, start);
            }
            if (num % 2 == 1) {
                check((num * 3) + 1, index + 1, start);
            }
        }
    }

    public static void main(String[] args){

        for (int i = 1; i < 1000000; i++){
            check(i, 1, i);
        }
        System.out.println(longest + " " + number);
    }
}
