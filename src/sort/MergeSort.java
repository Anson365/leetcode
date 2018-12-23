package sort;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 2017/12/13.
 */
public class MergeSort {
    public static void merge(int[] array){
      int[] temp = new int[array.length];
      doMerge(array,temp,0,array.length-1);

    }

    private static void doMerge(int[] array,int[] temp,int start,int end){
        if(start>=end){ //end recursion
            return;
        }
        int tempIndex = (end - start)/2 + start ; //middle

        doMerge(array,temp,start,tempIndex); //merge sort left
        doMerge(array,temp,tempIndex+1,end); // merge sort right
        //after merge sort ,merge the left and right
        int k=start,n=tempIndex+1,i=start;
        while (k<=tempIndex&&n<=end){
            temp[i++]=array[k]>array[n]?array[n++]:array[k++];
        }
        while (k<=tempIndex){
            temp[i++]=array[k++];
        }
        while (n<=end){
            temp[i++]=array[n++];
        }
        for(int j=start;j<=end;j++){
            array[j] = temp[j];
        }
    }

//    public static void main(String[] args){
//        int[] array = {23,34,62,12,51,4,14,3,5,7};
//        MergeSort.merge(array);
//        Helper.ordered(array);
//    }
}
