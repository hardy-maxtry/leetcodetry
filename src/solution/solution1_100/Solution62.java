package solution.solution1_100;

public class Solution62 {
    public int uniquePaths(int m, int n) {
        int [][] result = new int[m][n];
        result[0][0] = 1;
        for (int i = 1; i < m ; i ++ ){
            result[i][0] =1;
        }
        for (int i = 1; i < n ; i ++ ){
            result[0][i] =1;
        }
        for (int i = 1; i < m; i ++){
            for (int j = 1; j < n; j++){
                result[i][j] = result[i-1][j] + result[i][j-1] ;
            }
        }
        return result[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        System.out.println(solution62.uniquePaths(3,7));
    }
}
