package string;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 7/6/18.
 */
public class BuddyStrings_859 {

    public boolean buddyStrings(String A, String B) {
        char[] aChars = A.toCharArray();
        char[] bChars = B.toCharArray();
        if (aChars.length != bChars.length) {
            return false;
        }
        if (A.equals(B)) {
            int[] tempArray = new int[26];
            for (int i = 0; i < aChars.length; i++) {
                int tempIndex = aChars[i] - 97;
                if (tempArray[tempIndex] > 0) {
                    return true;
                } else {
                    tempArray[tempIndex] = tempArray[tempIndex] + 1;
                }
            }
            return false;
        }
        Character tempA = null,tempB = null;
        Boolean changed = false;
        for(int i = 0; i < aChars.length; i++) {
            if (aChars[i] == bChars[i]) {
                continue;
            }
            // if do not do the change operations
            if (!changed && tempA == null && tempB == null) {
                tempA = aChars[i];
                tempB = bChars[i];
            } else { // if did the change operations
                // not equal after change
                if (tempA != bChars[i] || tempB != aChars[i]) {
                    return false;
                } else {
                    changed = true;
                    tempA = null;
                    tempB = null;
                }
            }
        }
        return tempA == null && tempB == null;
    }

    public static void main(String[] args) {
        BuddyStrings_859 buddyStrings_859 = new BuddyStrings_859();
        boolean result = buddyStrings_859.buddyStrings("ab", "ab");
        System.out.println(result);
    }
}
