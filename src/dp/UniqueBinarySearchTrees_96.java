package dp;

/**
 * Created by ludao on 2017/4/28.
 */
public class UniqueBinarySearchTrees_96 {
    public int numTrees(int n) {
        int[] tree = new int[n+1];
        tree[0] = tree[1] = 1;
        int length = n + 1;
        for(int i=2;i<length;i++){
            for(int j=1;j<=i;j++){
                tree[i] += tree[j-1]*tree[i-j];
            }
        }
        return tree[n];
    }
}
