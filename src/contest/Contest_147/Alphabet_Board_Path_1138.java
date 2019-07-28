package contest.Contest_147;

/**
 * @author luodaihua
 * Created on 2019-07-28
 */
public class Alphabet_Board_Path_1138 {
    public String alphabetBoardPath(String target) {
        StringBuilder res = new StringBuilder();
        char start = 'a';
        for (char c : target.toCharArray()) {
            res.append(caluateDiff(start, c));
            res.append('!');
            start = c;
        }
        return res.toString();
    }


    private String caluateDiff(char current, char target) {
        StringBuilder tmp = new StringBuilder();
        if (current == target) {
            return "";
        }
        if (current == 'z') {
            return "U" + caluateDiff('u', target);
        }
        if (target == 'z') {
            return caluateDiff(current, 'u') + "D";
        }
        int rowDiff = (target - 'a') / 5 - (current - 'a') / 5;
        int columnDiff = (target - 'a') % 5 - (current - 'a') % 5;
        char row = 'D', column = 'R';
        if (rowDiff < 0) {
            row = 'U';
        }

        if (columnDiff < 0) {
            column = 'L';
        }
        for (int i = 0; i < Math.abs(rowDiff); i++) {
            tmp.append(row);
        }
        for (int i = 0; i < Math.abs(columnDiff); i++) {
            tmp.append(column);
        }
        return tmp.toString();
    }
}
