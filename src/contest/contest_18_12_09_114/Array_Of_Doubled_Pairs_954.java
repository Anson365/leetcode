package contest.contest_18_12_09_114;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/8/18.
 */
public class Array_Of_Doubled_Pairs_954 {
    public boolean canReorderDoubled_II(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer[] tempAarray = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            map.put(a, map.getOrDefault(a, 0) + 1);
            tempAarray[i] = a;
        }
        Arrays.sort(tempAarray, (i1, i2) -> {
            return Math.abs((int)i1) - Math.abs((int)i2);
        });
        for (int a : tempAarray) {
            if (!map.containsKey(a)) {
                continue;
            }
            int target = 2 * a;
            if (!map.containsKey(target)) {
                return false;
            } else {
                int tempCount = map.get(target);
                if (a == target) {
                    if (tempCount >= 2) {
                        if (tempCount == 2) {
                            map.remove(a);
                        } else {
                            map.put(a, tempCount - 2);
                        }
                    } else {
                        return false;
                    }
                } else {
                    if (tempCount > 0) {
                        if (tempCount == 1) {
                            map.remove(target);
                        } else {
                            map.put(target, tempCount - 1);
                        }
                        int tempA = map.get(a);
                        if (tempA == 1) {
                            map.remove(a);
                        } else {
                            map.put(a, tempA - 1);
                        }
                    } else {
                        return false;
                    }
                }
            }
            if (map.isEmpty()) {
                return true;
            }
        }

        return false;
    }


    public boolean canReorderDoubled(int[] A) {
        TreeMap<Integer, Integer> pos = new TreeMap<>(), neg = new TreeMap<>();
        for (int a : A) {
            if (a < 0) {
                neg.put(a, neg.getOrDefault(a, 0) + 1);
            } else {
                pos.put(a, pos.getOrDefault(a, 0) + 1);
            }
        }

        for (Integer temp : pos.keySet()) {
            if (pos.get(temp) > 0) {
                if (pos.get(temp) > pos.getOrDefault(temp * 2, 0)) {
                    return false;
                }
                pos.put(temp * 2, pos.get(temp * 2) - pos.get(temp));
            }
        }

        for (Integer temp : neg.keySet()) {
            if (temp % 2 == 1) {
                return false;
            }
            if (neg.get(temp) > 0) {
                if (neg.get(temp) > neg.getOrDefault(temp / 2, 0)) {
                    return false;
                }
                neg.put(temp / 2, neg.get(temp/2) - neg.get(temp));
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Array_Of_Doubled_Pairs_954 arrayOfDoubledPairs954 = new Array_Of_Doubled_Pairs_954();
        arrayOfDoubledPairs954.canReorderDoubled(new int[]{4,2,4,4,2,-4,0,-2,0,4});
    }
}
