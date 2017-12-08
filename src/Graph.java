import java.util.*;

public class Graph {

    private int[][] edges;
    private int vertexCount;

    public Graph(int c){
        edges = new int[c][];
        vertexCount = c;

        for (int i = 0; i < c; i++){
            edges[i] = new int[i+1];
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    /**
     * Gets the weight of the edge between v1 and v2
     * @param v1
     * @param v2
     * @return value of the edge, -1 if infinity (not connected)
     */
    public int getWeight(int v1, int v2){
        int temp;
        if (v1 > v2){
            temp = edges[v1][v2];
        }
        else{
            temp = edges[v2][v1];
        }
        return temp;
    }

    /**
     * Will add an edge 75% of the time
     */
    public void generateDense(){
        Random rand = new Random();

        for (int i = 0; i < vertexCount; i++){
            for(int j = 0; j <= i; j++){
                if (rand.nextInt(100) + 1 <= 75){
                    edges[i][j] = rand.nextInt(10);
                }
                else {
                    edges[i][j] = -1;
                }
            }
        }
    }


    /**
     * Will add an edge 25% of the time
     */
    public void generateSparse(){
        Random rand = new Random();

        for (int i = 0; i < vertexCount; i++){
            for(int j = 0; j <= i; j++){
                if (rand.nextInt(100) + 1 >= 75){
                    edges[i][j] = rand.nextInt(10);
                }
                else {
                    edges[i][j] = -1;
                }
            }
        }
    }

    /**
     * @return Sorted ArrayList of Edges
     */
    public List<Edge> getSortedVertexSet(){
        return sortList(getEdgeArray());
    }


    /**
     *
     * @return list of all edges (not counting infinite)
     */
    private List<Edge> getEdgeArray(){
        List<Edge> e = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j <= i; j++) {
                if (this.edges[i][j] != 0 ){
                    e.add(new Edge(i, j, edges[i][j]));
                }
            }
        }
        return e;
    }

    /**
     * Sort a list of edges
     * @param e
     * @return sorted list
     */
    private List<Edge> sortList(List<Edge> e){
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
            System.out.print("{" + temp.getVertex1() + ", " + temp.getVertex2() + ", " + temp.getWeight() + "} ");
        }
        System.out.println();
    }

    /**
     * default util for printing the weights of the edges array
     */
    public void printEdges(){
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j <= i; j++) {
                if(edges[i][j] != -1){
                    System.out.print(edges[i][j] + " ");
                }
                else{
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }

}
