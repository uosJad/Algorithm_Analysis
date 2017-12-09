import java.util.*;

/**
 * Created by jason on 12/8/17.
 */
public class UtilClass {
    public UtilClass(){}

    public List<Integer> randomList(int n){
        Random rand = new Random();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++){
            temp.add(rand.nextInt(100));
        }
        return temp;
    }

    public void printList(List<Integer> list){
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            System.out.print(it.next() + ", ");
        }
        System.out.println();
    }

    /**
     * Sort a list of edges
     * @param e
     * @return sorted list
     */
    public List<Edge> sortList(List<Edge> e){
        Collections.sort(e, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });

        return e;
    }

    /**
     * Util function for printing the edges of a List
     * @param e
     */
    public void printEdges(List<Edge> e){
        Iterator<Edge> it = e.iterator();
        while (it.hasNext()){
            Edge temp = it.next();
            if (temp.getVertex2() > temp.getVertex1()){
                System.out.print("{" + temp.getVertex1() + ", " + temp.getWeight() + ", " + temp.getVertex2() + "} ");
            }
            else{

                System.out.print("{" + temp.getVertex2() + ", " + temp.getWeight() + ", " + temp.getVertex1() + "} ");
            }
        }
        System.out.println();
    }
}
