package contest.contest_153;

/**
 * @author luodaihua
 * Created on 2019-09-08
 */
class Contest2 {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
        int week = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
        return weeks[week];
    }
}
