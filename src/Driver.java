import java.util.List;

public class Driver {
    public static void main(String[] args){
        Graph g = new Graph(10);

        g.generateDense();
        //g.printEdges();
        System.out.println();
        List<Edge> sortedList = g.getSortedVertexSet();
        //g.printEdges(sortedList);

    }
}
