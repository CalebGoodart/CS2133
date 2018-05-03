public class Countries{

    private int area;
    private int perimeter;
    private String name;
    private States[] states;
    private Countries[] borderOf;
    private Cities capital;
    private Countries[] neighbors;

    public Countries(String name, int area, int perimeter, States[] states, Countries[] borderOf, Cities capital, Countries[] neighbors){

        this.area = area;
        this.perimeter = perimeter;
        this.name = name;
        this.states = states;
        this.borderOf = borderOf;
        this.capital = capital;
        this.neighbors = neighbors;
    }

    public States[] getStates() {
        return states;
    }

    public String getName(){
        return name;
    }

    public int area(){
        return area;
    }

    public int boundaryLength(){
        return perimeter;
    }

    public Countries[] borderOf(){
        return borderOf;
    }

    public Countries[] neighbors(){
        return neighbors;
    }

    public Cities capital(){
        return capital;
    }
}