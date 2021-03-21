package solution.solution1_100;

import java.util.*;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String >> map = new HashMap<>();
        for (String s : strs){

            char[] tmpCharArr = s.toCharArray();
            Arrays.sort(tmpCharArr);
            String s1 = String.valueOf( tmpCharArr);
            if (!map.containsKey(s1)){
                map.put(s1, new ArrayList<>());
            }
            map.get(s1).add(s);
        }
        List<List<String>> result = new ArrayList<>();
        for (String s : map.keySet()){
            result.add(map.get(s));
        }
        return result;

    }
}
