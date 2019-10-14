package contest.contest_158;

class Contest1 {
    public int balancedStringSplit(String s) {
        int count = 0;
        int temp = 0;
        for (char c : s.toCharArray()) {
            temp += (c == 'R' ? 1 : -1);
            if (temp == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Contest1 contest1 = new Contest1();
        contest1.balancedStringSplit("RLRRLLRLRL");
    }
}
