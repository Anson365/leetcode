package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anson on 12/22/18.
 */
public class Momenta_Test1 {
    public List<int[]> calIntersection(List<int[]> t1, List<int[]> t2) {
        List<int[]> result = new ArrayList<>();

        if (t1 == null || t1.size() == 0 || t2 == null || t2.size() == 0) {//输入某个矩形为空
            return result;
        }

        int hl1 = t1.get(0)[0];
        int zl1 = t1.get(0)[1];
        int hr1 = t1.get(1)[0];
        int zr1 = t1.get(1)[1];
        int length1 = hr1 - hl1;
        int height1 = zl1 - zr1;


        int hl2 = t2.get(0)[0];
        int zl2 = t2.get(0)[1];
        int hr2 = t2.get(1)[0];
        int zr2 = t2.get(1)[1];
        int length2 = hr2 - hl2;
        int height2 = zl2 - zr2;


        if ( (hl1 > hr2 || hr1 < hl2) && (zl1 < zr2 || zr1 > zl2 )) { //两个矩形的横纵坐标不想交
            return result;
        }
        //矩形包含或者完全重合
        if ((hr2 - hr1) * (hl1 - hl2) >= 0 && (zl2 - zl1) * (zr1 - zr2) >= 0) {
            if (length1 * height1 < length2 * height2) { //包含关系取面积小的那个
                return t1;
            } else {
                return t2;
            }
        }


        //矩形部分重合
        int length = (hr2 - hl2) - Math.abs(hl1 - hl2);//求重合矩形的长
        int height = (zl2- zr2) - Math.abs(zl1 - zl2);//求重合矩形的宽

        int resulthl = Math.max(hl1, hl2);            //求重合矩形的左上角横坐标
        int resultzl = Math.max(zr1, zr2) + height;   //求重合矩形的左上角纵坐标
        int resulthr = resulthl + length;             //求重合矩形的右下角横坐标
        int resultzr = Math.max(zr1, zr2);            //求重合矩形的右下角纵坐标


        int[] A = new int[] {resulthl, resultzl};
        int[] B = new int[] {resulthr, resultzr};
        result.add(A);
        result.add(B);
        return result;
    }

//    public static void main(String[] args) {
//        Momenta_Test1 momenta_test1 = new Momenta_Test1();
//        List<int[]> l1 = new ArrayList<>();
//        List<int[]> l2 = new ArrayList<>();
//        l1.add(new int[]{0, 2});
//        l1.add(new int[]{2, 0});
//
//        l2.add(new int[]{0, 2});
//        l2.add(new int[]{2, 0});
//
//
//        momenta_test1.calIntersection(l1, l2);
//    }
}
