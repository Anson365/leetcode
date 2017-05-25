package dp;

/**
 * Created by ludao on 2017/4/27.
 */
public class LongestPalindromicSubsequence_516 {
    public int longestPalindromeSubseq(String s) {
        if(s==null||s.length()==0){
            return 0;
        }else {
            int[][] tempArray = new int[s.length()][s.length()];
            return helper(s,0,s.length()-1,tempArray);
        }
    }
    private int helper(String s,int start,int end,int[][] tempArray){
        if(start==end){
            tempArray[start][end]=0;
            return 1;
        }else {
            if(tempArray[start][end]!=0){
                return tempArray[start][end];
            }
            if(s.charAt(start)==s.charAt(end)){
                tempArray[start][end] = helper(s,start+1,end-1,tempArray) + 2;
            }else {
                tempArray[start][end] =  Math.max(helper(s,start+1,end,tempArray),helper(s,start,end-1,tempArray));
            }
            return tempArray[start][end];
        }
    }

//    public int longestPalindromeSubseq(String s){
//        if(s==null||s.length()==0){
//            return 0;
//        }else {
//            int length = s.length();
//            int[][] tempArray = new int[length][length];
//            for(int i=length-1;i>=0;i--){
//                tempArray[i][i] = 1;
//                for(int j=i+1;j<length;j++){
//                    if (s.charAt(i) == s.charAt(j)) {
//                        tempArray[i][j] = 2 + tempArray[i + 1][j - 1];
//                    } else {
//                        tempArray[i][j] = Math.max(tempArray[i+1][j],tempArray[i][j-1]);
//                    }
//                }
//            }
//            return tempArray[0][length-1];
//        }
//    }
}
