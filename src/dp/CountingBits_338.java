package dp;

/**
 * Created by ludao on 2017/4/26.
 */
public class CountingBits_338 {
    public int[] countBits(int num) {
        int length = num + 1;
        int[] result = new int[length];
        result[0] = 0;
        for(int i=1;i<length;i++){
            int tempIndex = i>>1;
            int tempMod = i%2;
            result[i] = result[tempIndex] + tempMod;
        }
        return result;
    }

    public static void main(String[] args){
        CountingBits_338 countingBits_338 = new CountingBits_338();
        int[] nums = countingBits_338.countBits(2);
        return;
    }
}
