package string;

/**
 * Created by Anson on 12/31/18.
 */
public class Reverse_Words_in_a_String_151 {

    public String reverseWords(String s) {
        String[] temp = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = temp.length - 1; i >= 0; i--) {
            if ("".equals(temp[i])) {
                continue;
            }
            result.append(temp[i]).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Reverse_Words_in_a_String_151 reverse_words_in_a_string_151 = new Reverse_Words_in_a_String_151();
        reverse_words_in_a_string_151.reverseWords("b   a");
    }
}
