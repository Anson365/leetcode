package divideAndConquer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/15/18.
 */
public class Different_Ways_to_Add_Parentheses_241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if (input == null) {
            return result;
        }
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (temp == '+' || temp == '-' || temp=='*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (Integer leftNum : left) {
                    for (Integer rightNum : right) {
                        int tempResult;
                        switch (temp) {
                            case '+' :
                                tempResult = leftNum + rightNum;
                                break;
                            case '-':
                                tempResult = leftNum - rightNum;
                                break;
                            default:
                                tempResult = leftNum * rightNum;
                        }
                        result.add(tempResult);
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }


}
