import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Median {


    public Median(){

    }

    public int sortMedian(List<Integer> arr){
        Collections.sort(arr);
        return arr.get(arr.size()/2);
    }

    public  int superMedian(int[] arr){

        //TODO

        return -1;
    }


}
