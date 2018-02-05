import java.util.ArrayList;
import java.util.Scanner;

public class Average {

    private static double getAverage(ArrayList<Double> numlist){

        double average=0;

        for(int i = 0; i < numlist.size(); i++ ){
            average += numlist.get(i);
        }
        average /= numlist.size();
        return average;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Double> average = new ArrayList<>();

        System.out.println("Enter a series of numbers. Enter a negative number to quit.");
        while (scan.hasNextDouble()){
            double number = scan.nextDouble();
            if (number <= 0){
                break;
            }else{
                average.add(number);
            }
        }
        System.out.print("You entered "+ average.size()+ " numbers averaging " + getAverage(average) + ".");
    }
}
