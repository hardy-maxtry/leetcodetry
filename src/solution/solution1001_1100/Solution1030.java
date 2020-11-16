package solution.solution1001_1100;

import java.util.*;

public class Solution1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Map<Integer, ArrayList<Integer[]>> map = new HashMap<>();
        Set<Integer> integers = new HashSet<>();
        for (int r = 0; r< R; r++){
            for (int c = 0; c<C ; c++){
                int value = Math.abs(r-r0) + Math.abs(c-c0);
                if (!map.containsKey(value)){
                    map.put(value,new ArrayList<>());
                }
                map.get(value).add(new Integer[]{r,c});
                integers.add(value);
            }
        }
        Integer[] arr = integers.toArray(new Integer[integers.size()]);
        Arrays.sort(arr);
        int[][] result = new int[R*C][];
        int pos = 0;
        for (int i : arr){
            for (Integer[] arr1: map.get(i)){
                result[pos++] = new int[]{arr1[0], arr1[1]};
            }
        }
        return result;


    }
}
