package dp;

import java.util.HashSet;

/**
 * Created by ludao on 2017/6/15.
 */
public class LongestPalindrome_409 {
        public int longestPalindrome(String s) {
            if(s==null||s.length()==0){
                return 0;
            }
            HashSet<Character> hashSet = new HashSet<Character>();
            int count = 0;
            for(int i=0;i<s.length();i++){
                Character temp = s.charAt(i);
                if(hashSet.contains(temp)){
                    count++;
                    hashSet.remove(temp);
                }else {
                    hashSet.add(temp);
                }
            }
            return hashSet.isEmpty()?count*2:count*2+1;
        }

//    public static void main(String[] s){
//        String str = "abccccdd";
//        LongestPalindrome_409 longestPalindrome_409 = new LongestPalindrome_409();
//        int temp = longestPalindrome_409.longestPalindrome(str);
//        System.out.print(true);
//
//    }
}
