package sort;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 2017/12/7.
 */
public class ShellSort {
    public static void sort(int[] array){
        int length = array.length;
        int step = 1;
        while ((step*3+1)<length){   // adapt step
            step = step*3 + 1;
        }
        while (step>0){  // reduce step to 1
            for(int i=0;i<step;i++){// group by step
                for(int j=i;j<length;j+=step){// sort by step
                    //insertion sort
                    int temp = array[j],//temp value
                            index = j-step;// pre j value
                    while (index>=i&&array[index]>temp){  // i is the floor
                        swap(array,index,index+step);
                        index -= step;
                    }
                }
            }
            step/=3;   //step indent
        }
    }
    private static void swap(int[] array,int sourceIndex,int targetIndex){
        int temp = array[sourceIndex];
        array[sourceIndex] = array[targetIndex];
        array[targetIndex] = temp;
    }
    private static boolean ordered(int[] array){
        boolean ordered = true;
        int i=1;
        while (ordered&&i<array.length){
            ordered = array[i]>=array[i-1];
            i++;
        }
        return ordered;
    }
    public static  void main(String[] args){
        int[] array = {23,34,62,12,51,4,14,3,5,7};
        ShellSort.sort(array);
        assert(ordered(array));
    }
}
