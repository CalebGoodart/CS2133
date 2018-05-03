public class Cities{

    private int area;
    private int perimeter;
    private String name;
    private States states;
    private Cities[] neighbors;
    private Cities[] borderOf;
    private boolean isCapital;
    private int X;
    private int Y;

    public Cities(String name, int area, int perimeter, boolean isCapital, States states, Cities[] neighbors, Cities[] borderOf, int X, int Y){

        this.area = area;
        this.perimeter = perimeter;
        this.name = name;
        this.isCapital = isCapital;
        this.states = states;
        this.neighbors = neighbors;
        this.borderOf = borderOf;
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public String getName() {
        return name;
    }

    public int area(){
        return area;
    }

    public int boundaryLength(){
        return perimeter;
    }

    public Cities[] neighbors(){
        return neighbors;
    }

    public Cities[] BorderOf() {
        return borderOf;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public States getStates() {
        return states;
    }

    public double distance(Cities cities1, Cities cities2){

        double distance;
        int x1 = cities1.getX();
        int x2 = cities2.getX();
        int y1 = cities1.getY();
        int y2 = cities2.getY();

        distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance;
    }
}
