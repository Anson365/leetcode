package string;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/4/18.
 */
public class ImplementStrStr_28 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int tempLength = needle.length();
        for (int i = 0; i < haystack.length() - tempLength; i++) {
            String tempStr = haystack.substring(i, i + tempLength);
            if (tempStr.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
