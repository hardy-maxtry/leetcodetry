package solution.solution401_500;

import java.util.Arrays;

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int result = 0;
        while( i < g.length && j < s.length){
            if (s[j] >= g[i]){
                i++;
                j++;
                result++;
            }else{
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution455 solution455 = new Solution455();
        int[] g  = {10,9,8,7};
        int[] s = {5,6,7,8};

        System.out.println(solution455.findContentChildren(g,s));
    }
}
