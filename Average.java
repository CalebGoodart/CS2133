import java.util.ArrayList;
import java.util.Scanner;

public class Average {

    private static double getAverage(ArrayList<Double> numlist){

        double average=0;

        for(int i = 0; i < numlist.size(); i++ ){
            average += numlist.get(i);
        }
        return average/numlist.size();

    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Double> average = new ArrayList<>();

        while(scan.hasNext()){
            if( scan.nextDouble() > 0 ) {
                average.add(scan.nextDouble());
            }else{
                break;
            }
        }

        System.out.print(getAverage(average));
    }
}
