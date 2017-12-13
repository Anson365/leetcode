package sort;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 2017/12/13.
 */
public class HeapSort {
    public static void heapSwim(int[] array){
        int n = (array.length+1)/2;
        //ordered heap
        for(int i=array.length-1;i>n;i--){
            swim(array,i);
        }
        for(int i=array.length-1;i>0;i--){
            Helper.swap(array,i,0);
            swim(array,i-1);//ordered heap;
        }
    }
    public static void heapSink(int[] array){
        int n = array.length/2;
        //ordered heap
        for(int i=0;i<=n;i++){
            sink(array,i,array.length-1);
        }
        for(int i=array.length-1;i>0;i--){
            Helper.swap(array,i,0);
            sink(array,0,i-1);//ordered heap;
        }
    }
    //compare with son,if less ,swap
    private static void sink(int[] array,int k,int restriction){
        while (k*2+1<=restriction){
            int temp;
            if(k*2+2<=restriction){
                temp = array[k*2+1]>array[k*2+2]?k*2+1:k*2+2;
            }else {
                temp = k*2+1;
            }
            if(array[k]>=array[temp]){
                break;
            }else {
                Helper.swap(array,k,temp);
                k = k*2+1;;
            }
        }
    }
    //compare with father, if greater ,swap
    private static void swim(int[] array,int k){
        while (k-1>=0){
            if(array[k]>array[(k-1)/2]){
                Helper.swap(array,k,(k-1)/2);
            }
            k = (k-1)/2;
        }
    }
    public static void main(String[] args){
        int[] array1 = {23,34,62,12,51,4,14,3,5,7};
        HeapSort.heapSink(array1);
        Helper.ordered(array1);
        int[] array2 = {23,34,62,12,51,4,14,3,5,7};
        HeapSort.heapSink(array2);
        Helper.ordered(array2);
    }
}
