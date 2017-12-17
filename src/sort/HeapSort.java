package sort;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 2017/12/13.
 */
public class HeapSort {

    public static void heapSink(int[] array){
        sink(array,array.length-1);//heap sort
        for(int i=array.length-1;i>0;i--){
            Helper.swap(array,i,0);
            doSink(array,0,i-1);//ordered heap;
        }
    }
    //compare with father, if greater ,swap
    private static void sink(int[] array,int k){
        int n = (k+1)/2-1;
        for(int i=n;i>=0;i--){
            doSink(array,i,k);
        }
    }
    private static void doSink(int[] array,int i,int k){
        int left = i*2+1,right=i*2+2;
        if(left>k){// have no children
            return;
        }
        int temp,tempVal;
        if(left<=k&&right>k) {//only have left child
            temp = left;
            tempVal = array[left];
        }else {//both have left and right child
            int leftVal = array[left],rightVal = array[right];
            temp = leftVal>rightVal?left:right;
            tempVal = leftVal>rightVal?leftVal:rightVal;
        }
        if(array[i]<tempVal){
            Helper.swap(array,i,temp);
            doSink(array,temp,k);
        }
    }


    public static void main(String[] args){


        int[] array2 = {23,34,62,12,51,4,14,3,5,7};
        HeapSort.heapSink(array2);
        Helper.ordered(array2);
    }


}
