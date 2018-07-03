package string;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 7/2/18.
 */
public class CountAndSay_38 {
    public String countAndSay(int n) {
        String temp = "1";
        for(int i = 2; i <= n; i++) {
            int length = temp.length();
            int count = 1;
            StringBuilder tempBuilder = new StringBuilder();
            for (int j = 1; j < length; j++) {
                if (temp.charAt(j) == temp.charAt(j-1)) {
                    count ++;
                } else {
                    tempBuilder.append(count).append(temp.charAt(j-1));
                    count = 1;
                }
            }
            tempBuilder.append(count).append(temp.charAt(length-1));
            temp = tempBuilder.toString();
        }
        return temp;
    }

    public static void main(String[] args) {
        CountAndSay_38 countAndSay_38 = new CountAndSay_38();
        countAndSay_38.countAndSay(2);
    }
}
