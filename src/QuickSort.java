/**
 * Created by ludao on 2017/6/28.
 */
public class QuickSort {

    public int[] doSort(int[] array){
        doQuickSort(array,0,array.length-1);
        return array;
    }

    public int doQuickSort(int[] array,int start,int end){

        int temp = array[start];
        while (start<end) {
            while (array[end] >= temp && end > start) end--;
            swap(array, start, end);
            while (array[start] <= temp && start < end) start++;
            swap(array, start, end);
        }
        return start;
    }

    private void swap(int[] array,int source,int target){
        int tempPos = array[source];
        array[source] = array[target];
        array[target] = tempPos;
    }


//    public static void main(String[] args){
//        int[] array = {3,23,5,61,2,4,6};
//        QuickSort quickSort = new QuickSort();
//        int[] sorted =  quickSort.doSort(array);
//    }
}
