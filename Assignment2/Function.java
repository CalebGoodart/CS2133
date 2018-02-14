public abstract class Function{

    public abstract double evaluate(double x);

    public double findRoot(double a, double b, double epsilon){

        double x = (a + b) / 2;

        if ( Math.abs((a - x)) < epsilon){
            return x;
        }else if ( ( evaluate(x) < 0 && evaluate(a) < 0 ) || ( evaluate(x) > 0 && evaluate(a) > 0) ){
            return findRoot(x, b, epsilon);
        }else {
            return findRoot(a, x, epsilon);
        }
    }
    public static void main(String[] args){
        int a = 1;
        double b =2;


    }
}
