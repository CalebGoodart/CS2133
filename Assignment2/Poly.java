public class Poly {

    private int[] coefficients;

    public Poly(int[] coefficients){

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

    public Poly add(Poly a){

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
        return new Poly(sums);
    }

    public double evaluate(double x){

        double total = 0;
        for (int i = 0; i < coefficients.length; i++){

            total += coefficients[i] * Math.pow(x,i);
        }
        return total;
    }

    public static void main(String[] args){

        int[] coesPoly1 = new int[4];
        coesPoly1[0] = 0;
        coesPoly1[1] = -2;
        coesPoly1[2] = 4;
        coesPoly1[3] = 1;
        Poly poly = new Poly(coesPoly1);

        int[] coesPoly = new int[6];
        coesPoly[0] = 4;
        coesPoly[1] = 0;
        coesPoly[2] = -8;
        coesPoly[3] = 0;
        coesPoly[4] = 3;
        coesPoly[5] = 2;
        Poly testPoly = new Poly(coesPoly);

        int[] added = new int[6];
        added[0] = 4;
        added[1] = -2;
        added[2] = -4;
        added[3] = 1;
        added[4] = 3;
        added[5] = 2;
        Poly addedPoly = new Poly(added);

        if (testPoly.degree() != 5) {
            System.out.println(" Degree test Failed " + testPoly.degree());
        }
        if (!(testPoly.toString().equals("2x^5+3x^4-8x^2+4"))){
            System.out.println("toString Test Failed " + testPoly.toString());
        }
        if ( !(poly.add(testPoly).toString().equals(addedPoly.toString())) ){
            System.out.println("Add test Failed " + poly.add(testPoly) + " " + addedPoly);
        }
        if (testPoly.evaluate(2) != 84){
            System.out.println("evaluate Test Failed " + testPoly.evaluate(2));
        }
    }
}
