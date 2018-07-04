package string;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 7/4/18.
 */
public class ComplexNumberMultiply_537 {
    public String complexNumberMultiply(String a, String b) {
        int[] aArray = mixContent(a);
        int[] bArray = mixContent(b);
        int tempInt = aArray[0] * bArray[0] - aArray[1] * bArray[1];
        int tempAbstract = aArray[0] * bArray[1] + bArray[0] * aArray[1];
        return tempInt + "+" + tempAbstract + "i";
    }


    private boolean isAbstract(String temp) {
        return temp.contains("i");
    }

    private int[] mixContent(String temp) {
        int[] array = new int[2];
        String[] tempArray = temp.split("\\+");
        if (tempArray.length < 2) {
            return array;
        }
        if (isAbstract(tempArray[0])) {
            String t = tempArray[0];
            tempArray[0] = tempArray[1];
            tempArray[1] = t;
        }
        array[0] = Integer.valueOf(tempArray[0]);
        array[1] = Integer.valueOf(tempArray[1].replaceAll("i", ""));
        return array;
    }
}
