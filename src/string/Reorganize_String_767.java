package string;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/14/18.
 */
public class Reorganize_String_767 {
    public String reorganizeString(String S) {
        if (S == null || S.length() < 2) {
            return S;
        }
        int[] temp = new int[26];
        for (char c : S.toCharArray()) {
            temp[c - 'a']++;
        }
        int lastIndex = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            lastIndex = findNext(temp, lastIndex);
            if (lastIndex < 0) {
                return "";
            } else {
                temp[lastIndex]--;
                sb.append((char)(lastIndex + 'a'));
            }
        }
        return sb.toString();

    }
    private int findNext(int[] temp, int lastIndex) {
        int index = -1;
        int max = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0 && i != lastIndex) {
                if (temp[i] > max) {
                    max = temp[i];
                    index = i;
                }
            }
        }
        return index;
    }

//    public static void main(String[] args) {
//        Reorganize_String_767 reorganize_string_767 = new Reorganize_String_767();
//        reorganize_string_767.reorganizeString("vvvlo");
//    }
}
