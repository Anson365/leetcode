package test;

/**
 * @author Anson
 * Created on 2019-10-17
 */
public class TestChild extends TestParent {

    protected void doTest1() {
        System.out.println("child test1");
    }


    public static void main(String[] args) {
        TestParent testChild = new TestChild();
        testChild.doTest();
    }
}
