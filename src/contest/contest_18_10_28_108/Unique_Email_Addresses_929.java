package contest.contest_18_10_28_108;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 10/28/18.
 */
public class Unique_Email_Addresses_929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] temp = email.split("@");
            String prefix = temp[0].split("\\+")[0];
            prefix = prefix.replaceAll("\\.", "");
            set.add(prefix + "@" + temp[1]);
        }
        return set.size();
    }
}
