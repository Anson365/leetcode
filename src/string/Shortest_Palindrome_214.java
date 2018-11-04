package string;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/2/18.
 */
public class Shortest_Palindrome_214 {
    public String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) { j += 1; }
        }
        if (j == s.length()) { return s; }
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }


    public static void main(String[] args) {
        Shortest_Palindrome_214 shortest_palindrome_214 = new Shortest_Palindrome_214();
        shortest_palindrome_214.shortestPalindrome("aacecaaa");
    }
}
