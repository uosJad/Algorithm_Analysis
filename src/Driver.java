import java.util.*;

public class Driver {
    public static void main(String[] args){
        MinSpan minSpan = new MinSpan();
        UtilClass elu = new UtilClass();
        Median median = new Median();

        //Graph g = new Graph(10000);
        List<Integer> intList = elu.randomList(100);
        //g.generateDense();
        //g.generateSparse();

        System.out.println();

        //List<Edge> sortedList = g.getSortedVertexSet();
        //elu.printEdges(sortedList);

        long time = System.currentTimeMillis();

        System.out.println();
        System.out.println("sort: " + median.sortMedian(intList));

        time = System.currentTimeMillis() - time;

        System.out.println(time);

        time = System.currentTimeMillis();

        //System.out.println();
        //System.out.println("super: " + median.superMedian(intList));

        //minSpan.kruskals(g);

        time = System.currentTimeMillis() - time;

        System.out.println(time);

/*
        System.out.println();
        elu.printEdges(minSpan.prims(g));

        System.out.println();
        elu.printEdges(minSpan.kruskals(g));

        System.out.println();
        List<Integer> intList = elu.randomList(10);
        List<Integer> intCopy = new ArrayList<>();
        Iterator<Integer> it = intList.iterator();
        while(it.hasNext()){
            intCopy.add(it.next());
        }

        elu.printList(intList);

        System.out.println();
        System.out.println("sort: " + median.sortMedian(intCopy));

        System.out.println();
        System.out.println("super: " + median.superMedian(intList));

*/
    }
}
