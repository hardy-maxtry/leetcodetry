package solution.solution201_300;

import java.util.HashMap;
import java.util.Map;

public class Solution205 {
    // map
    public boolean isIsomorphic1(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i++){
            if (map.containsKey(tArr[i])){
                char tmp = map.get(tArr[i]);
                if (tmp != sArr[i]){
                    return false;
                }
            }else{
                map.put(tArr[i],sArr[i]);
            }

            if (map2.containsKey(sArr[i])){
                char tmp = map2.get(sArr[i]);
                if (tmp != tArr[i]){
                    return false;
                }
            }else{
                map2.put(sArr[i],tArr[i]);
            }
        }
        return true;
    }

    // array
    public boolean isIsomorphic(String s, String t) {
        int[] map1 = new int[128];
        int[] map2 = new int[128];

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i++){
            if (map1[tArr[i]]>0){
                if (map1[tArr[i]] != sArr[i] + 1){
                    return false;
                }
            }else{
                map1[tArr[i]] = sArr[i] + 1;
            }

            if (map2[sArr[i]]>0){
                if (map2[sArr[i]] != tArr[i] + 1){
                    return false;
                }
            }else{
                map2[sArr[i]] = tArr[i] + 1;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution205 solution205 = new Solution205();
//        System.out.println(solution205.isIsomorphic("ab", "ca"));
//        System.out.println(solution205.isIsomorphic("aa", "ab"));
        System.out.println(solution205.isIsomorphic("13", "42"));
    }
}
