package sort;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 2017/12/14.
 */
public class BTSSort {

    private static int index = 0;

    public static void doSort(int[] array){
       Tree bts = buildBTS(array);
       LNR(bts,array);
    }

    public static Tree buildBTS(int[] array){
        Tree tree = new Tree(array[0]);
        for(int i=1;i<array.length;i++){
            int temp = array[i];
            Tree point = tree;
            while (true){
                if(point.val>temp){ // less than root
                    if(point.left!=null){//compare with left child
                        point = point.left;
                    }else {
                        point.left = new Tree(temp);//set current as left child
                        break;
                    }
                }else {//greater than root
                    if(point.right!=null) { //compare with right child
                        point = point.right;
                    }else {//set current as right child
                        point.right = new Tree(temp);
                        break;
                    }
                }
            }
        }
        return tree;
    }


    public static void LNR(Tree tree,int[] array){
       if(tree==null){
           return;
       }
       //left
        LNR(tree.left,array);
       //Native
        array[index++]=tree.val;
       //right
        LNR(tree.right,array);
    }


    static class Tree{
        public Tree(int val) {
            this.val = val;
        }

        int val;
        Tree left;
        Tree right;
    }


    public static void main(String[] args){
        int[] array = {23,34,62,12,51,4,14,3,5,7};
        BTSSort.doSort(array);
        Helper.ordered(array);
    }
}
