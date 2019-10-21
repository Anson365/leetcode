package test;

/**
 * @author Anson
 * Created on 2019-10-17
 */
public class TestParent {
    public void doTest() {
        System.out.println("test");
        doTest1();
    }

    protected void doTest1() {
        System.out.println("test1");
    }
}
