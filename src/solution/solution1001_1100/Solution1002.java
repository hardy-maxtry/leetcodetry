package solution.solution1001_1100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1002 {
    public List<String> commonChars(String[] A) {
        Map<Character, Integer> charCount = new HashMap<>();
        for(int i = 0; i < A.length ; i++){
            String s = A[i];
            Map<Character, Integer> charCountInWord = new HashMap<>();
            for(Character c: s.toCharArray()){
                if (!charCountInWord.containsKey(c)){
                    charCountInWord.put(c,0);
                }
                charCountInWord.put(c, charCountInWord.get(c)+1);
            }
            if (i==0){
                for(Character c: charCountInWord.keySet()){
                    charCount.put(c, charCountInWord.get(c));
                }
            }else{
                for (Character c: charCount.keySet()){
                    if (!charCountInWord.containsKey(c)){
                        charCount.put(c, 0);
                    }else{
                        if(charCountInWord.get(c) < charCount.get(c)){
                            charCount.put(c, charCountInWord.get(c));
                        }
                    }
                }
            }


        }
        List<String> result = new ArrayList<>();
        for(Character c: charCount.keySet()){
            if (charCount.get(c) > 0){
                for (int j = 0; j < charCount.get(c) ; j++){
                    result.add(c.toString());
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        String[] inArgs = new String[]{"bella","label","roller"};
        String[] inArgs2 = new String[]{"cool","lock","cook"};
        Solution1002 solution1002 = new Solution1002();
        List<String> result = solution1002.commonChars(inArgs2);
        System.out.println(String.join(",",result));
    }
}
