/**
 * Created by ludao on 2017/3/16.
 */
public class Test {

    public static void doSomething(){
        char start = 'A',end = 'Z';
        for(int i=start;i<end;i++){
            String pre = "INSERT INTO `PublicTag` (`name`, `spell`, `description`, `classify`, `type`, `useScene`) VALUES (\"%s\",\"%s\",\"%s\",1,1,0);";
            for(int j=0;j<21;j++){
                System.out.println(String.format(pre,((char)i)+""+ j,((char)i)+""+ j,((char)i)+""+ j));
            }

        }
    }

    public static void main(String[] args){
        doSomething();
    }
}
