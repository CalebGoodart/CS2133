public class Boundaries {

    Cities[] cities;
    int length;

    public Boundaries(Cities[] cities, int length){

        this.cities = cities;
        this.length = length;
    }

    public Cities[] boundaries() {

        return cities;
    }

    public int getLength(){
        return length;
    }
}
