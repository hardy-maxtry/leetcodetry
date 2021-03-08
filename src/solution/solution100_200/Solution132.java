package solution.solution100_200;

import java.util.Arrays;

public class Solution132 {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isR = new boolean[n][n];
        for (int row = 0; row < n; row++){
            Arrays.fill(isR[row], true);
        }
        /*  构建回文词数组，isR[left][right]表示从left~right的子字符串是回文字符串
             考虑以下二维数组， 由于left<=right，因此以left为行，right为列
             对角线为left==right字符串中，每个字母本身，一定为回文字符串, 即为1(true)
             二维数组下半部分，代表right<left的情况，不存在该情况，直接视作1(true)
             二维数组上半部分，left<right是否为回文字符串，需要单独计算
             left~right是否回文 = left+1~right-1是否回文 && s.charAt(left) == s.charAt(right)
             其中  left+1 > right-1时，代表[left][right]命中星号位置，考虑到数组下半部分无需参与运算，只需要判断 s.charAt(left) == s.charAt(right)即可
            1 * ? ?
            1 1 * ?
            1 1 1 *
            1 1 1 1
        */
        for (int row = n-1; row >= 0; row--){
            for (int column = row+1; column < n; column++){
                isR[row][column] = (s.charAt(row) == s.charAt(column)) && isR[row+1][column-1];
            }
        }

        int[] result = new int[s.length()];

        Arrays.fill(result, Integer.MAX_VALUE);

        for (int right = 0; right < n; right++){
            // 从 0 ~ 当前字符串，直接构成回文，无需拆分, result[i]=0
            if (isR[0][right]){
                 result[right] = 0;
            }else {
                for (int left = 1; left <= right; left++){
                    if (isR[left][right]){
                        // 从 left~right构成回文，即如果 0~left-1 切分X次构成回文，外加left~right这一次，结果为 X + 1
                        // 也就是 result[right] = result[left-1]+1
                        // 同时考虑到 result[right]可能已经参与过计算，取最小值即可
                        result[right] = Math.min(result[right], result[left-1]+1);
                    }
                }
            }
        }
        return result[n-1];
    }
}
