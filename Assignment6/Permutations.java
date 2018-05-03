import java.util.ArrayList;

public class Permutations {

    private ArrayList<Integer> list;
    private int index;
    private int c;
    private Permutations P;
    private Permutations L;
    private ArrayList<ArrayList<Integer>> fulllist;
    private ArrayList<ArrayList<Integer>> tempList;
    private int fullIndex;

    public Permutations(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> fulllist){

        this.list = list;
        this.fulllist = fulllist;
        this.tempList = new ArrayList<ArrayList<Integer>>();

        if (list.size() != 2){

            c = this.list.get(0);
            list.remove(0);
            P = new Permutations(list, fulllist);
            this.fulllist = P.getFulllist();

            System.out.println("P");
            for (int i = 0; i < this.fulllist.size(); i++){
                System.out.println(fulllist.get(i));
            }
            System.out.println();
            next();

        }else {

            c = this.list.get(0);
            list.remove(0);
            next();

            for (int i = 0; i < tempList.size(); i++){
                fulllist.add(tempList.get(i));
            }
        }

    }

    public ArrayList<ArrayList<Integer>> getFulllist() {
        return fulllist;
    }

    public boolean hasNext(){

        if (index < list.size()){
            return true;
        }else{
            return false;
        }
    }

    public void getnext(){

        for (int i = 0; i < fulllist.size(); i++){

            list = fulllist.get(i);
            next();
        }

    }

    public void next(){

        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.println("list -" + list);
        for (int i = 0; i < list.size(); i++){

            arrayList.add(list.get(i));
        }
        list.add(0,c);

        for (index = 0; index < list.size(); index++){
            arrayList.add(index, c);

            tempList.add(new ArrayList<Integer>());

            System.out.print("arrayList- " + arrayList);

            for (int i = 0; i < arrayList.size(); i++){
                tempList.get(fullIndex).add(arrayList.get(i));
            }
            fullIndex++;
            System.out.println();


            for (int i = 0; i < tempList.size(); i++){

                System.out.println("tempList- " + tempList.get(i));
            }

            arrayList.remove(index);

        }




    }

    public static void main(String[] args){

        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrayListArrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        Permutations permutations = new Permutations(arrayList, arrayListArrayList);
        }
}
