package stack;

import java.util.Stack;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/9/18.
 */
public class Largest_Rectangle_in_Histogram_84 {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int temp = heights[i];
            int left = i, right = i;
            while (left >= 0 && heights[left] >= temp) {
                left--;
            }
            while (right < heights.length && heights[right] >= temp) {
                right++;
            }
            max = Math.max(max, (right - left - 1) * temp);
        }
        return max;
    }

    public int largestRectangleArea1(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

//    public static void main(String[] args) {
//        Largest_Rectangle_in_Histogram_84 largest_rectangle_in_histogram_84 = new Largest_Rectangle_in_Histogram_84();
//        largest_rectangle_in_histogram_84.largestRectangleArea1(new int[] {2,1,5,6,2,3});
//    }
}
