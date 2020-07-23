package solution;

public class Solution61_80 {
    // id 64 最小路径和，动态规划
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] result = new int[row][column];
        result[0][0] = grid[0][0];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(i==0 && j>0){
                    result[i][j] = result[i][j-1] + grid[i][j];
                }else if(j==0 && i >0){
                    result[i][j] = result[i-1][j] + grid[i][j];
                }else if(i>0 && j >0){
                    result[i][j] = Math.min(result[i-1][j], result[i][j-1]) + grid[i][j];
                }

            }
        }
        return result[row-1][column-1];
    }

    public static void main(String[] args){
        Solution61_80 solution61_80 = new Solution61_80();
        int[][] arr = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int r = solution61_80.minPathSum(arr);
        System.out.println(r);
    }
}
