package interview.sacle;

/**
 * Created by ludao on 2017/6/11.
 */
public class AZSCALE {

    public int helper(String az){
        int result = 0,length=az.length();
        for(int i=0;i<length;i++){
            int temp = az.charAt(i)-'A';
            if(i!=length-1){
                temp++;
            }
            result = result*26+temp;
        }
        return result;
    }

//    public static void main(String[] args){
//        String az = "BB";
//        AZSCALE azscale = new AZSCALE();
//        System.out.println(azscale.helper(az));
//    }
}
