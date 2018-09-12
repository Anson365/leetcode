package string;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 9/12/18.
 */
public class Find_the_Closest_Palindrome_564 {
    public String nearestPalindromic(String n) {
        long num = Long.valueOf(n);
        int length = n.length();
        long leftValue = Long.valueOf(n.substring(0, length - length/2));
        long preLeftValue = leftValue - 1;
        long nexLeftValue = leftValue + 1;


        long curP = helper(leftValue, length);
        long preP = helper(preLeftValue, length);
        long nextP = helper(nexLeftValue, length);

        long absCur = Math.abs(curP - num);
        long absPre = Math.abs(preP - num);
        long absNex = Math.abs(nextP - num);

        long tempResult ;
        if (num == curP) {
            tempResult = absPre > absNex ? nextP : preP;
        } else if (num > curP) {
            tempResult = absCur > absNex ? nextP : curP;
        } else {
            tempResult = absPre > absCur ? curP : preP;
        }

        return tempResult + "";
    }

    private long helper(long n, int length) {
        if (n == 0) {
            return length == 1 ? 0 : 9;
        }
        StringBuilder temp = new StringBuilder().append(n);
        StringBuilder reverse = temp.reverse();
        if (temp.length() < length/2) {
            reverse.append(9);
        }
        String resultStr = temp.append(reverse).toString();
        return Long.valueOf(resultStr);
    }

    public static void main(String[] args) {
        Find_the_Closest_Palindrome_564 find_the_closest_palindrome_564 = new Find_the_Closest_Palindrome_564();
        find_the_closest_palindrome_564.nearestPalindromic("1");
    }

}
