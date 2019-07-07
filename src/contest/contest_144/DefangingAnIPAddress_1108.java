package contest.contest_144;

/**
 * @author luodaihua
 * Created on 2019-07-07
 */
public class DefangingAnIPAddress_1108 {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
