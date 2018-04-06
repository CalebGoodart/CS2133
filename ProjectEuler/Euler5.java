public class Euler5 {

    public static void main(String[] args){

        int number = 0;
        boolean test = true;

        for (int i = 1; i < 1000000000; i++){
            for (int j = 1; j < 20; j++){

                if ((i % j == 0) && test){
                    //System.out.println("true" + " " + i + " " + j);
                    test = true;
                }else{
                    //System.out.println("false" + " " + i + " " + j);
                    test = false;
                }
            }
            if (test){
                number = i;
                break;
            }
            test = true;
        }

        System.out.println(number);
    }
}
