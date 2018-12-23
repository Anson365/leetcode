package others;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 2017/12/18.
 */
public class Hanoi {

    private int stepCount = 0;

    public void doStep(int n,String from,String inter,String to){
        if(n==1){
            System.out.println(String.format("%s -> %s",from,to));
            stepCount++;
        }else {
            doStep(n-1,from,to,inter);
            System.out.println(String.format("%s -> %s",from,to));
            stepCount++;
            doStep(n-1,inter,from,to);
        }
    }


//    public static void main(String[] args){
//        Hanoi hanoi = new Hanoi();
//        hanoi.doStep(3,"A","B","C");
//        System.out.println("total step is "+ hanoi.stepCount);
//    }
}
