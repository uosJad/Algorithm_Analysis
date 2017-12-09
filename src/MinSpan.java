import java.util.ArrayList;
import java.util.List;

public class MinSpan {

    public MinSpan(){

    }

    public List<Edge> prims(Graph g){

        List<Edge> sortedList = g.getSortedVertexSet();
        List<Edge> result = new ArrayList<>();

        List<Integer> nearest = new ArrayList<>(); //index of the nearest vertex to i
        List<Integer> minDist = new ArrayList<>(); //min edge distance to i


        //start at index 0
        nearest.add(0, -2);
        minDist.add(0, -2);
        for (int i = 1; i < g.getSize(); i++){
            nearest.add(i, 0);
            minDist.add(i, g.getWeight(i, 0));
        }

        for (int n = 1; n < g.getSize(); n++ ){
            int min = -1;
            int minIndex = -1;

            //get min edge
            for (int i = 1; i < minDist.size(); i++){
                if (min == -1 && minDist.get(i) > 0){
                    min = minDist.get(i);
                    minIndex = i;
                }
                else if(minDist.get(i) < min && minDist.get(i) > 0){
                    min = minDist.get(i);
                    minIndex = i;
                }
            }

            //nearest.get(minIndex);
            //add min edge
            result.add(new Edge(nearest.get(minIndex), min, minIndex));
            minDist.set(minIndex, -2); //set the distance to the new node to be -2 to indicate already visited

            //if the edge from the new added node is smaller than all others, add thatbas the new min edge
            for (int i = 1; i < minDist.size(); i++){
                if (minDist.get(i) == -1 && g.getWeight(i, minIndex) != -1){
                    minDist.set(i, g.getWeight(i, minIndex));
                    nearest.set(i, minIndex);
                }
                else if (g.getWeight(i, minIndex) != -1 && g.getWeight(i, minIndex) < minDist.get(i) ){
                    minDist.set(i, g.getWeight(i, minIndex));
                    nearest.set(i, minIndex);
                }
                else if (g.getWeight(i, minIndex) != -1 && minDist.get(i) == 0){
                    minDist.set(i, g.getWeight(i, minIndex));
                    nearest.set(i, minIndex);
                }
            }
        }

        return result;
    }

    public List<Edge> kruskals(Graph g){

        List<Edge> sortedGraph = g.getSortedVertexSet();
        List<Edge> result = new ArrayList<>();

        //TODO


        return result;
    }



}
