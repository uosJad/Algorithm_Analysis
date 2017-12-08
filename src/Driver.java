import java.util.List;

/**
 * Created by jason on 12/7/17.
 */
public class Driver {
    public static void main(String[] args){
        Graph g = new Graph(10000);

        g.generateDense();
        //g.printEdges();
        System.out.println();
        List<Edge> sortedList = g.getSortedVertexSet();
        //g.printEdges(sortedList);

    }
}
