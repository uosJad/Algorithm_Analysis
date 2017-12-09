import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jason on 12/8/17.
 */
public class DisjointSet {
    int[] sets; //roots, indices = vertices


    public DisjointSet(int size){
        sets = new int[size];

        for (int i = 0; i < size; i++){
            sets[i] = i;
        }
    }

    public List<Integer> find(int x){
        List<Integer> result = new ArrayList<>();
        int r = sets[x];
        result.add(x);
        for (int i = 0; i < sets.length; i++){
            if (sets[i] == r){
                result.add(i);
            }
        }
        return result;
    }

    public boolean isInSameSet(List<Integer> l1, List<Integer> l2){
        if (sets[l1.get(0)] == sets[l2.get(0)]){
            return true;
        }
        return false;
    }

    public void merge(int a, int b){
        int r = sets[a];
        List<Integer> bSet = find(b);
        Iterator<Integer> it = bSet.iterator();
        while (it.hasNext()){
            sets[it.next()] = r;
        }
    }

}
