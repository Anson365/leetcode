package string;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 7/3/18.
 */
public class LengthOfLastWord_58 {

    public int lengthOfLastWord(String s) {
        char[] array = s.toCharArray();
        int index = array.length - 1;
        while (index >= 0 && array[index] == ' ') {
            index--;
        }
        if (index < 0) {
            return 0;
        }
        int temp = index;
        while (temp >= 0 && array[temp] != ' ') {
            temp--;
        }
        return index - temp;
    }

    public int lengthOfLastWord2(String s) {
        s = s.trim();
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int temp = length - 1;
        while (temp >= 0 && s.charAt(temp) != ' ') {
            temp--;
        }
        return length - 1 - temp;
    }

//    public static void main(String[] args) {
//        LengthOfLastWord_58 lengthOfLastWord_58 = new LengthOfLastWord_58();
//        lengthOfLastWord_58.lengthOfLastWord(" ");
//    }
}
