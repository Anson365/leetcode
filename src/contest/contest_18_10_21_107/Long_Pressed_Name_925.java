package contest.contest_18_10_21_107;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/21/18.
 */
public class Long_Pressed_Name_925 {
    public boolean isLongPressedName(String name, String typed) {
        if (typed == null && name == null) {
            return true;
        }
        if (typed == null || name == null) {
            return false;
        }
        if (typed.equals(name)) {
            return true;
        }
        int nameIndex = 0;
        char[] charArray = typed.toCharArray();
        char lastChar = charArray[0];
        for (char c : charArray) {
            if (nameIndex >= name.length()) {
                if (c != lastChar){
                    return false;
                } else {
                    continue;
                }
            }
            if (c == name.charAt(nameIndex)) {
                nameIndex ++;
                lastChar = c;
            } else {
                if (c != lastChar) {
                    return false;
                }
            }
        }
        return nameIndex == name.length();
    }

    public static void main(String[] args) {
        Long_Pressed_Name_925 long_pressed_name_925 = new Long_Pressed_Name_925();
        long_pressed_name_925.isLongPressedName("vtkgn", "vttkgnn");
    }
}
