package solution.solution700_800;

import java.util.Arrays;

public class Solution766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
//        int[] tmp1 = new int[matrix[0].length];
        int rowsCount = matrix.length;
        int columnsCount = matrix[0].length;
//        int[] tmp1 = Arrays.copyOf(matrix[0], columnsCount);

        for (int i = 1; i < rowsCount; i++){
            for (int j = 1; j < columnsCount; j++){
                if (matrix[i-1][j-1] != matrix[i][j]){
                    return false;
                }
            }
//            tmp1 = Arrays.copyOf(matrix[i], columnsCount);
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] input = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        Solution766 solution766 = new Solution766();
        System.out.println(solution766.isToeplitzMatrix(input));
    }
}
