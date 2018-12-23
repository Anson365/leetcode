package string;

import java.util.Arrays;

public class NextGreaterElementIII_556 {
    public int nextGreaterElement(int n) {
        String nStr = String.valueOf(n);
        char[] chars = nStr.toCharArray();
        int length = chars.length;
        Integer temp = null;
        for(int i=length-2;i>=0;i--){
            char currentChar = chars[i];
            if(currentChar<chars[i+1]){
                temp = i;
//                swap(chars,i,i+1);
                int newTemp = i+1;
                while (newTemp+1<length&&chars[temp]<chars[newTemp+1]){
                    newTemp++;
                }
                if(newTemp+1<length&&chars[temp]<chars[newTemp+1]){
                    swap(chars,temp,temp+1);
                }else {
                    swap(chars,temp,newTemp);
                }
                temp = temp+1;
                break;
            }
        }
        if(temp==null){
            return -1;
        }
        char[] start = new char[temp];
        char[] end = new char[length-temp];
        for(int i=0;i<length;i++){
            if(i<temp){
                start[i]=chars[i];
            }else {
                end[i-temp]=chars[i];
            }
        }
        Arrays.sort(end);
        String newStr = String.valueOf(start) + String.valueOf(end);
        Long tempResult = Long.valueOf(newStr);
        return tempResult==n||tempResult>Integer.MAX_VALUE?-1:tempResult.intValue();
    }

    private void swap(char[] chars,int source,int target){
        char tempChar = chars[source];
        chars[source] = chars[target];
        chars[target] = tempChar;
    }

//    public static void main(String[] args){
//        NextGreaterElementIII_556 nextGreaterElementIII_556 = new NextGreaterElementIII_556();
//        int result = nextGreaterElementIII_556.nextGreaterElement(12443322);
//        System.out.println(result);
//    }
}
