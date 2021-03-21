package solution.solution1101_1200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for(int i : arr1){
            if(!map1.containsKey(i)){
                map1.put(i, 1);
            }else{
                map1.put(i, map1.get(i)+1);
            }
        }

        int[] result = new int[arr1.length];
        int pos = 0;
        for(int i : arr2){
            map2.put(i, 1);
            Integer countOfI = map1.get(i);
            for(int j = pos; j < pos+countOfI; j++){
                result[j] = i;
            }
            pos += countOfI;
        }

        int pos2 = pos;
        for(Integer i : map1.keySet()){
            if(!map2.containsKey(i)){
                for (int j = 0; j < map1.get(i); j ++){
                    result[pos2] = i;
                    pos2++;
                }
            }
        }
        Arrays.sort(result,pos, result.length);
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] arr2 = new int[]{2,42,38,0,43,21};

        Solution1122 solution1122 = new Solution1122();
        solution1122.relativeSortArray(arr1, arr2);
    }
}
