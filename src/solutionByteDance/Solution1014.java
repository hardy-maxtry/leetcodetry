package solutionByteDance;

public class Solution1014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }

        String result = findCommon(strs[0], strs[1]);
        if (strs.length == 2){
            return result;
        }
        for (int i = 2 ; i < strs.length; i++){
            result = findCommon(result, strs[i]);
        }
        return result;
    }

    public String findCommon(String s1, String s2){
        String result = "";
        for (int i = 0, j =0; i< s1.length() && j < s2.length(); i++, j++){
            if (s1.charAt(i) == s2.charAt(j)){
                result = result + s1.charAt(i);
            }else{
                break;
            }
        }
        return result;
    }

    public String longestCommonPrefix2(String[] strs) {

        if (strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }

        String result = strs[0];

        for (int i = 1; i < strs.length; i++){
            while( !strs[i].startsWith(result)){
                result = result.substring(0, result.length() -1 );
            }
        }
        return result;
    }
}
