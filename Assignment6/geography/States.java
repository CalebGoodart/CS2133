public class States{

    private int area;
    private int perimeter;
    private String name;
    private Cities[] cities;
    private Countries countries;
    private Cities capital;
    private States[] neighbors;
    private States[] borderOf;

    public States(String name, int area, int perimeter, Cities[] cities, Countries countries, Cities capital, States[] neighbors, States[] borderOf){

        this.area = area;
        this.perimeter = perimeter;
        this.name = name;
        this.cities = cities;
        this.capital = capital;
        this.countries = countries;
        this.neighbors = neighbors;
        this.borderOf = borderOf;
    }

    public String getName() {
        return name;
    }

    public Cities[] getCities() {
        return cities;
    }

    public Countries getCountries() {
        return countries;
    }

    public int area(){
        return area;
    }

    public Cities capital() {
        return capital;
    }

    public int boundaryLength(){
        return perimeter;
    }

    public States[] neighbors(){
        return neighbors;
    }

    public States[] BorderOf() {
        return borderOf;
    }
}
