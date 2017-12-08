/**
 * Created by jason on 12/7/17.
 */
public class Edge {

    private int vertex1, vertex2;
    private int weight;


    public Edge(int v1, int v2, int e){
        vertex1 = v1;
        vertex2 = v2;
        weight = e;
    }

    public int getVertex1() {
        return vertex1;
    }

    public void setVertex1(int vertex1) {
        this.vertex1 = vertex1;
    }

    public int getVertex2() {
        return vertex2;
    }

    public void setVertex2(int vertex2) {
        this.vertex2 = vertex2;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
