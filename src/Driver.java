import java.util.List;

public class Driver {
    public static void main(String[] args){
        MinSpan minSpan = new MinSpan();
        EdgeListUtil elu = new EdgeListUtil();
        Graph g = new Graph(10);

        g.generateDense();
        g.printEdges();
        System.out.println();
        List<Edge> sortedList = g.getSortedVertexSet();
        elu.printEdges(sortedList);

        System.out.println();
        elu.printEdges(minSpan.prims(g));

    }
}
