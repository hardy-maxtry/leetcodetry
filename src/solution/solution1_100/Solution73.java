package solution.solution1_100;

import java.util.Arrays;

public class Solution73 {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int[] zeroX = new int[matrix.length];
        int[] zeroY = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    zeroX[i] = 1;
                    zeroY[j] = 1;
                }
            }
        }
        for (int i = 0; i < zeroX.length; i++){
            if (zeroX[i] == 1){
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j = 0; j < zeroY.length; j++){
            if (zeroY[j] == 1){
                for (int i = 0; i < matrix.length;i++){
                    matrix[i][j] = 0;
                }

            }
        }
    }
}
