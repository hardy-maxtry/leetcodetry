package solution.solution201_300;

import java.util.HashMap;
import java.util.Map;

public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        char[] patternArr = pattern.toCharArray();

        String[] strs = s.split(" ");
        if (patternArr.length != strs.length){
            return false;
        }
        for (int i = 0; i < patternArr.length; i++){
            if (!map.containsKey(patternArr[i]) && !map2.containsKey(strs[i])){
                map.put(patternArr[i], strs[i]);
                map2.put(strs[i], patternArr[i]);
            }else{
                if((!map.containsKey(patternArr[i]) && map2.containsKey(strs[i])) || ( map.containsKey(patternArr[i]) && !map2.containsKey(strs[i]))){
                    return false;
                }
                if (!map.get(patternArr[i]).equals(strs[i]) || !map2.get(strs[i]).equals(patternArr[i])){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution290 solution290 = new Solution290();
        System.out.println(solution290.wordPattern("abc",
                "dog cat dog"));
    }
}
