package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 2017/8/22.
 */
public class LexicographicalNumbers_386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        if(n<1){
            return result;
        }
        for(int i=1;i<10&&i<=n;i++)
            helper(i,n,result);
        return result;
    }

    private void helper(int i,int n,List<Integer> list){
        if(i>n) {
            return;
        }
        list.add(i);
        if(10*i<=n){
            for(int temp=0;temp<10;temp++){
                if(10*i+temp>n){
                    return;
                }
                helper(10*i+temp,n,list);
            }
        }
    }
}
