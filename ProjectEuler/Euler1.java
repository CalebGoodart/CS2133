import java.math.BigDecimal;

public class Euler1 {

    public static void main(String[] args){

        BigDecimal sum = BigDecimal.valueOf(0);
        for(int i = 1; i <= 1000; i++){
            sum += BigDecimal.valueOf(Math.pow(i, i));
            System.out.println(i + "  " + sum);
        }
        System.out.println(sum);
    }
}
