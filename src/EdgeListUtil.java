import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jason on 12/8/17.
 */
public class EdgeListUtil {
    public EdgeListUtil(){}

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
