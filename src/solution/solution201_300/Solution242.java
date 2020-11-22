package solution.solution201_300;

import java.util.HashMap;
import java.util.Map;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        Map<Character , Integer> map = new HashMap<>();
        for (Character c: s.toCharArray()){
            if (!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c) + 1);
            }
        }

        for (Character c: t.toCharArray()){
            if (map.containsKey(c)){
                int count = map.get(c);
                if (count == 0){
                    return false;
                }
                map.put(c, count - 1);
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "abcd";
////        String t = "dcba";
//        String t = "dcbaa";
////        String t = "dcbe";
        String s = "abcd123呵呵哒";
        String t = "呵呵哒123abcd";
        Solution242 solution242 = new Solution242();
        System.out.println(solution242.isAnagram(s, t));
    }
}
