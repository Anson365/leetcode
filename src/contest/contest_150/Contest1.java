package contest.contest_150;

/**
 * @author luodaihua
 * Created on 2019-08-18
 */
class Contest1 {

    public int countCharacters(String[] words, String chars) {
        int[] array = new int[26];
        int result = 0;
        for (int i = 0; i < chars.length(); i++) {
            array[chars.charAt(i) - 'a']++;
        }
        for (int i = 0; i < words.length; i++) {
            if (isContains(array, words[i])) {
                result += words[i].length();
            }
        }
        return result;
    }

    private boolean isContains(int[] array, String word) {
        int[] temp = new int[26];
        for (int j = 0; j < word.length(); j++) {
            int index = word.charAt(j) - 'a';
            temp[index]++;
            if (temp[index] > array[index]) {
                return false;
            }
        }
        return true;
    }
}
