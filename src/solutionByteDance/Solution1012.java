package solutionByteDance;


// 无重复字符的最长子串
public class Solution1012 {
    public int lengthOfLongestSubstring(String s) {


        char[] chars = s.toCharArray();

        int left = 0;
        int right = 0;
        String tmpStr = "";
        int result = 0;
        for(int i = 0; i<chars.length; i++){
            int tmpPos = tmpStr.indexOf(chars[i]);
            if (tmpPos>=0){

                result = Math.max(result, i - left );
                left = left+tmpPos+1;
                tmpStr = s.substring(left, i+1);
            }else{
                tmpStr = tmpStr + chars[i];
            }

        }

        return Math.max(result, tmpStr.length());
    }

    public static void main(String[] args) {
        Solution1012 solution1012 = new Solution1012();
        System.out.println(solution1012.lengthOfLongestSubstring("cccccc"));
    }
}
