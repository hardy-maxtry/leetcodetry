package solution.solution1801_1900;

public class Solution1801 {
    public void rotate(int[][] matrix) {
        // 旋转时，避免遍历到已经替换的位置
        // 例如4*4数组，下标<length/2也就是下标0,1
        // 例如5*5数组，下标<(length+1)/2也就是下标0,1,2
        int n = matrix.length;
        for (int i = 0; i < matrix.length / 2; i++){
            for (int j = 0; i < matrix.length / 2; i++){
                int tmp = matrix[i][i];
                //对于位置i, j ，寻找哪个位置的数字，在旋转后，会落到m[i][j]位置
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;

            }
        }
    }

    public void rotate2(int[][] matrix) {
        // 水平上下反转
        // 对于奇数行，下标为5/2=2，也就是 0,1, 注意这里第二行为中间行，不需要翻转
        // 对于偶数行，下标为4/2=2, 也就是 0,1
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++){
            for(int j = 0; j < n; j ++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = tmp;
            }
        }

        // 对角线翻转
        // j<i 而不是j<=i, 因为i==j 在对角线上，不需要翻转
        for (int i = 0; i < n  ; i++){
            for(int j = 0; j < i; j ++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

}
