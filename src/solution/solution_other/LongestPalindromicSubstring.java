package solution.solution_other;

/**
 * 最长回文字符串
 */
public class LongestPalindromicSubstring {

    /**
     * 中心扩散法，转移方程  dp[i-1][j+1] = dp[i][j] && str[i-1] == str[j+1]
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = 1;
        int strStart = 0;
        int strEnd = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int right = 1; right<s.length(); right++){
            for(int left = 0; left < right; left ++){
                if(s.charAt(left) == s.charAt(right)
                        && ( (right - left >=0 && right -left <=2) || dp[left+1][right-1] == true)){
                    dp[left][right] = true;
                    if(right - left + 1 > len){
                        len = right - left + 1;
                        strStart = left;
                        strEnd = right;

                    }
                }
            }
        }
        return s.substring(strStart, strEnd + 1);
    }

    public static void main(String[] args){
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        // abbbba
        // abbabb
        // abbcbbabbcbba
        // abbcbbabbc1bba
        // ""
        // null
        String r = l.longestPalindrome("abbcbbabbc1bba");
        System.out.println(r);

    }
}
