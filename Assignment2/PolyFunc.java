public class PolyFunc extends Function {

    private int[] coefficients;

    public PolyFunc(int[] coefficients){

        this.coefficients = coefficients;
    }

    public int degree(){

        int highest = 0;
        if (coefficients[0] == 0) {
            for (int i = 1; i < coefficients.length ; i++) {
                if (coefficients[i] != 0){
                    return coefficients.length - 1 - i;
                }
            }
        }else {
            return coefficients.length - 1;
        }
        return highest;
    }

    public String toString(){

        String a = "";
        for (int i = coefficients.length - 1; i >= 0; i--){

            if (coefficients[i] != 0 && (coefficients[i] != coefficients[0]) && (coefficients[i] != coefficients[1])) {
                if (coefficients[i] > 0 && (coefficients[i] != coefficients[coefficients.length - 1]) ) {
                    a += "+";
                }
                if (coefficients[i] != 1){
                    a += coefficients[i] + "x^" + i;
                }else{
                    a += "x^" + i;
                }
            }else if (coefficients[i] == coefficients[1] && (coefficients[i]) != 0) {
                if (coefficients[i] > 0 && (coefficients[i] != coefficients[coefficients.length - 1]) ) {
                    a += "+";
                }
                if ((coefficients[i] != 1) && (coefficients[i] != 0) ){
                    a += coefficients[i] + "x";
                }else{
                    a += "x";
                }
            }else if ((coefficients[i] == coefficients[0])){
                if (coefficients[i] > 0 && (coefficients[i] != coefficients[coefficients.length - 1]) ) {
                    a += "+";
                }
                a += coefficients[i];
            }
        }
        return a;
    }

    public PolyFunc add(PolyFunc a){

        int[] sums;
        int[] shortArray;
        int[] longArray;

        if (a.coefficients.length < coefficients.length){
            shortArray = a.coefficients;
            longArray = coefficients;
            sums = new int[coefficients.length];
        }else{
            shortArray = coefficients;
            longArray = a.coefficients;
            sums = new int[a.coefficients.length];
        }

        for (int i = 0; i < sums.length; i++){
            if (i < shortArray.length) {
                sums[i] = longArray[i] + shortArray[i];
            }else{
                sums[i] = longArray[i];
            }
        }
        return new PolyFunc(sums);
    }

    public double evaluate(double x){

        double total = 0;
        for (int i = 0; i < coefficients.length; i++){

            total += coefficients[i] * Math.pow(x,i);
        }
        return total;
    }
}
