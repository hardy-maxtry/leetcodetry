package solution.solution300_400;

public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        // 预处理
        t = " " + t; // 开头加一个空字符作为匹配入口
        int n = t.length();
        // 记录26个子母中，某个字母相对与当前下标来说，下一次的出现位置
        // 例如 *abcdea,  这里的*是上面补足的首位, *的下标为0,
        // 则a相对于下标0来说，下一次出现的位置是1, 因此dp[0][0] = 1，a相对于下标1来说,  下一个出现位置是6，因此a[1][0]=6 a[2][0]=6
        // c相对于下标0来说， 下一次出现位置是3，因此db[0][2] = 3,   c相对于下标4来说，没有再出现过，因此a[4][2] = -a
        int[][] dp = new int[n][26];
        for (char ch = 0; ch < 26; ch++) {
            int p = -1;
            for (int i = n - 1; i >= 0; i--) { // 从后往前记录dp
                dp[i][ch] = p;
                if (t.charAt(i) == ch + 'a') p = i;
            }
        }
        for(int i[] : dp){
            for(int j : i){
                System.out.print(j);
                System.out.print(",");
            }
            System.out.println();

        }
        // 匹配
        int i = 0;
        for (char ch : s.toCharArray()) { // 跳跃遍历
            i = dp[i][ch - 'a'];
            if (i == -1) return false;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "ada";
        String t = "aveaniceday";
        Solution392 solution392 = new Solution392();
        solution392.isSubsequence(s, t);

    }
}
