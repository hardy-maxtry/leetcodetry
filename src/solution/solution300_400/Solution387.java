package solution.solution300_400;

import java.util.Arrays;

public class Solution387 {
    public int firstUniqChar(String s) {
        int[] charPosArr = new int[26];
        Arrays.fill(charPosArr, -2);
        char[] originCharArr = s.toCharArray();
        for (int i = 0; i < originCharArr.length; i++){
            char c= originCharArr[i];
            if (charPosArr[c - 'a'] == -1){
                continue;
            }else if(charPosArr[c - 'a'] == -2) {
                charPosArr[c - 'a'] = i;
            }else{
                charPosArr[c - 'a'] = -1;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i : charPosArr){
            if (i >= 0){
                result = Math.min(result, i);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args){
        Solution387 solution387 = new Solution387();
        System.out.println(solution387.firstUniqChar("leetcode"));

    }
}
