package solution.solution1201_1300;

import java.util.HashMap;

public class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map= new HashMap<>();
        for (int i: arr){
            if (!map.containsKey(i)){
                map.put(i, 0);
            }
            map.put(i, map.get(i)+1);
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i: map.keySet()){
            if (countMap.containsKey(map.get(i))){
                return false;
            }
            countMap.put(map.get(i), 1);
        }
        return true;
    }
}
