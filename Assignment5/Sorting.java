public class Sorting {

    public static double[] createArrays(int n){

        double[] array = new double[n];

        for (int i = 0; i < array.length; i++){

            array[i] = Math.random();
        }
        return array;
    }

    public static boolean bubbleSort(double[] array, long start){


        boolean swapped = false;
        for (int i = 0; i < array.length - 1; i++){

            for (int j = 0; j < array.length - i - 1; j++){

                if (array[j] < array[j + 1]){
                    double temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }
            }

            if ((System.currentTimeMillis() - start) > 20000){
                System.out.println("Bubble Sort ran out of time!");
                return true;
            }
            if (!swapped){
                break;
            }
        }

        System.out.println("Bubble sort finished in " + (System.currentTimeMillis() - start) + " milliseconds");
        return false;
    }

    public static boolean mergeSort(double[] array, long start){

        if (split(array,0,array.length -1, start)){
            System.out.println("Merge sort has failed!");
            return true;
        }

        System.out.println("Merge sort finished in " + (System.currentTimeMillis() - start) + " milliseconds");
        return false;
    }

    public static boolean split(double[] array, int l, int r, long start){

        if (l<r){
            int m = (l+r)/2;

            split(array,l, m, start);
            split(array, m + 1, r, start);

            if ((System.currentTimeMillis() - start) > 20000){
                System.out.println("Merge Sort ran out of time!");
                return true;
            }

            if (merge(array, l, m, r, start)){
                return true;
            }
        }

        return false;
    }

    public static boolean merge(double[] array, int l, int m, int r, long start){

        if ((System.currentTimeMillis() - start) > 20000){
            System.out.println("Merge Sort ran out of time!");
            return true;
        }

        double[] temp1 = new double[m - l + 1];
        double[] temp2 = new double[r - m];

        for (int i = 0; i < temp1.length; i++){

            temp1[i] = array[l + i];
        }

        for (int i = 0; i < temp2.length; i++){

            temp2[i] = array[m + 1 + i];
        }

        int index1 = 0;
        int index2 = 0;
        int index3 = l;

        while (index1 < temp1.length && index2 < temp2.length){

            if (temp1[index1] <= temp2[index2]){
                array[index3] = temp1[index1];
                index1++;
            }else {
                array[index3] = temp2[index2];
                index2++;
            }
            index3++;
        }

        while (index1 < temp1.length){
            array[index3] = temp1[index1];
            index1++;
            index3++;
        }

        while (index2 < temp2.length){
            array[index3] = temp2[index2];
            index2++;
            index3++;
        }

        return false;
    }

    public static void main(String[] args){

        try {
            for (int n = 10; true; n = n * 10){

                System.out.println("N = " + n);
                double[] array = createArrays(n);
                boolean test1;
                boolean test2;
                test1 = bubbleSort(array, System.currentTimeMillis());
                test2 = mergeSort(array, System.currentTimeMillis());

                if (test1 && test2){

                    System.out.println("Both sorts have failed!");
                }


            }
        }catch (OutOfMemoryError e){
            System.out.println("Ran out of memory!");
        }
    }
}
// n^2 seem to do better with small sets of numbers but get very slow with larger numbers
// n log n sort slightly slower with smaller sets of number but sort large numbers quicker