package solution.solution401_500;

import java.util.HashMap;
import java.util.Map;

public class Solution454 {
    // 超过时间限制
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for(int a : A){
            for (int b: B){
                map1.put(a+b, map1.getOrDefault(a+b, 0)+1);
            }
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int c : C){
            for (int d: D){
                map2.put(c+d, map2.getOrDefault(c+d, 0)+1);
            }
        }
        int result = 0;
        for (int key1 : map1.keySet()){
            for (int key2: map2.keySet()){
                if (key1 + key2 == 0){
                    result += map1.get(key1) * map2.get(key2);
                }
            }
        }
        return result;
    }

    // 减少一个map消耗
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for(int a : A){
            for (int b: B){
                map1.put(a+b, map1.getOrDefault(a+b, 0)+1);
            }
        }
        int result = 0;
        for(int c : C){
            for (int d: D){
                int tmp = - c - d;
                // map1 中存在相反数即可
                if (map1.containsKey(tmp)){
                    result += map1.get(tmp);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1,2};
        int[] D = {0,2};
        Solution454 solution454 = new Solution454();
        int r = solution454.fourSumCount2(A,B,C,D);
        System.out.println(r);
    }
}
