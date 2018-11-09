package jvm;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 11/8/18.
 */
public class GCTest {

    private static final int OneM = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * OneM];
        allocation2 = new byte[2 * OneM];
        allocation3 = new byte[2 * OneM];
        allocation4 = new byte[2 * OneM];
    }

    public static void main(String[] args) {
        GCTest.testAllocation();
    }
}
