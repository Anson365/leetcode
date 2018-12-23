package greedy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ludao on 2017/4/5.
 */
public class LargestNumber_179 {
    public String largestNumber(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        Integer[] number = new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            number[i] = nums[i];
        }
        Arrays.sort(number, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                String o1Str = o1.toString();
                String o2Str = o2.toString();
                Integer temp1 = Integer.valueOf(o1Str + o2Str);
                Integer temp2 = Integer.valueOf(o2Str + o1Str);
                if(temp1>temp2){
                    return -1;
                }else {
                    return 1;
                }
            }
        });
        StringBuilder result = new StringBuilder();
        int numLength = number.length;
        for (int i=0;i<numLength;i++){
            result.append(number[i]);
        }
        if(result.toString().startsWith("0")){
            return "0";
        }
        return result.toString();
    }

//    public static void main(String[] args){
//        int[] nums = {12,128};
//        LargestNumber_179 largestNumber_179 = new LargestNumber_179();
//        String resullt = largestNumber_179.largestNumber(nums);
//        System.out.println(resullt);
//    }
}
