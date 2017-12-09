import java.util.*;

public class Median {


    public Median(){

    }

    public int sortMedian(List<Integer> arr){
        Collections.sort(arr);
        return arr.get((arr.size())/2);
    }

    public int superMedian(List<Integer> list){
        return Select(list, (list.size())/2);
    }

    public int Select(List<Integer> list, int selection){

        if (list.size() <= 5){
            int temp = AdhocSelect(list, selection);
            return temp;
        }

        int medSize = list.size()/5;
        if (list.size()%5 != 0){
            medSize++;
        }
        List<Integer> medians = new ArrayList<>();

        for (int i = 0; i < medSize; i++){

            List<Integer> listCopy = new ArrayList<>();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()){
                listCopy.add(it.next());
            }

            int e = listCopy.size() - 1;
            if (5*i+4 < listCopy.size()) {
                e = 5*i+4;
            }

            List<Integer> temp = listCopy.subList(5*i, e+1);
            medians.add(i, AdhocSelect(temp, (temp.size()-1)/2));
        }

        List<Integer> medianCopy = new ArrayList<>();
        Iterator<Integer> it = medians.iterator();
        while (it.hasNext()){
            medianCopy.add(it.next());
        }

        int pivot = Select(medianCopy, (medSize-1)/2 );
        int pivotIndex = partition(list, pivot);
        int p = pivotIndex;
        int q = pivotIndex;

        for (int i = pivotIndex-1; i >= 0; i--){
            if (list.get(i) != pivot){
                p = i + 1;
                break;
            }
        }

        for (int i = pivotIndex+1; i < list.size(); i++){
            if (list.get(i) != pivot){
                q = i - 1;
                break;
            }
        }


        if (selection < p){
            return Select(list.subList(0, p-1 +1), selection);
        }
        else if (selection > q){
            return Select(list.subList(q+1, list.size()-1 + 1), selection - q - 1);
        }
        else{
            return pivot;
        }


        /*
        if (selection < pivotIndex){
            return Select(list.subList(0, p-1 +2), selection);
        }
        else if (selection > pivotIndex){
            return Select(list.subList(q+1, list.size()-1 + 1), selection - q - 1);
        }
        else{
            return pivot;
        }
        */

    }


    public int AdhocSelect(List<Integer> list, int selection){
        List<Integer> sortedList = AdhocSort(list);
        return sortedList.get(selection);
    }

    public List<Integer> AdhocSort(List<Integer> list) {
        if (list.size() == 1) {
            return list;
        }
        else if (list.size() == 2) {
            return AdhocSort2(list);
        }
        else if (list.size() == 3) {
            return AdhocSort3(list);
        }
        else if (list.size() == 4) {
            return AdhocSort4(list);
        }
        return AdhocSort5(list);

    }

    public List<Integer> AdhocSort2(List<Integer> list){
        if (list.get(0) > list.get(1)){
            return swap(list, 0, 1);
        }
        return list;
    }

    public List<Integer> AdhocSort3(List<Integer> list){
        if (list.get(0) > list.get(1)) {
            list = swap(list, 0, 1);
        }

        return insert(list.subList(0,1 + 1), list.get(2));
    }

    public List<Integer> AdhocSort4(List<Integer> list){
        if (list.get(0) > list.get(1)){
            list = swap(list,0, 1);
        }
        if (list.get(2) > list.get(3)){
            list = swap(list, 2, 3);
        }
        if (list.get(0) > list.get(2)) {
            List<Integer> temp = list.subList(2,3+1);
            temp.addAll(list.subList(0,1+1));
            list = temp;
        }

        List<Integer> temp = new ArrayList<>();
        List<Integer> temp2 = insert(list.subList(2,3 +1), list.get(1));
        temp.add(list.get(0));
        temp.addAll(temp2);
        return temp;
    }

    public List<Integer> AdhocSort5(List<Integer> list){
        if (list.get(0) > list.get(1)){
            list = swap(list,0, 1);
        }
        if (list.get(2) > list.get(3)) {
            list = swap(list, 2, 3);
        }
        if (list.get(0) > list.get(2)) {
            List<Integer> temp = list.subList(2,3+1);
            temp.addAll(list.subList(0,1+1));
            temp.addAll(list.subList(4,4+1));
        }

        List<Integer> temp = list.subList(0,0+1);
        temp.addAll(list.subList(2,3+1));
        List<Integer> listX = insert(temp, list.get(4));

        List<Integer> temp2 = new ArrayList<>();
        List<Integer> temp3 = insert(listX.subList(1,3+1), list.get(1));
        temp2.add(listX.get(0));
        temp2.addAll(temp3);

        return temp2;
    }


    public List<Integer> swap(List<Integer> list, int a, int b){
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
        return list;
    }

    public List<Integer> insert(List<Integer> list, int x){
        if (x < list.get(1)) {
            if (x < list.get(0)) { //if less than lowest
                int temp = list.get(0);
                list.set(0, x);
                int temp2 = list.get(1);
                list.set(1, temp);
                if (list.size() == 3){
                    int temp3 = list.get(2);
                    list.set(2, temp2);
                    list.add(temp3);
                }
                else{
                    list.add(temp2);
                }
                return list;
            } else { // if in between 0 and 1
                if (list.size() == 2) {
                    int temp = list.get(1);
                    list.set(1, x);
                    list.add(temp);
                    return list;
                } else {
                    int temp = list.get(1);
                    list.set(1, x);
                    int temp2 = list.get(2);
                    list.set(2, temp);
                    list.add(temp2);
                    return list;
                }
            }
        }
        else { // if more than index 1
            if (list.size() == 2 || x > list.get(2)){ // if more than index 2 or no other number at end
                list.add(x);
                return list;
            }
            else { //if less than 2
                int temp = list.get(2);
                list.set(2, x);
                list.add(temp);
                return list;
            }
        }
    }

    public int partition(List<Integer> list, int pivot){
        int index = -1;

        for (int i = 0; i < list.size(); i++){
            if (list.get(i) == pivot){
                index = i;
                break;
            }
        }

        int place = 0;
        for (int check = 0; check < list.size(); check++){
            if (list.get(check) < pivot){
                swap(list, check, place);
                place++;
            }
        }

        if (place > index){
            if (list.get(place) < pivot){
                swap(list, place, index);
            }
        }
        else if (place < index){
            if (list.get(place) > pivot){
                swap(list, place, index);
            }
        }

        return place;
    }
}
