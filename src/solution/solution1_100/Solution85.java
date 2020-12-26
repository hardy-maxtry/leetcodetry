package solution.solution1_100;

public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0){
            return 0;
        }
        int[][] tmp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i<matrix.length; i++){
            int rowCountOf1 = 0;
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == '1'){
                    rowCountOf1++;
                }else{
                    rowCountOf1 = 0;
                }

                tmp[i][j] = rowCountOf1;
            }
        }
        int result = 0;
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){

                if (matrix[i][j] == '0'){
                    continue;
                }

                int width = tmp[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k --){
                    width = Math.min(width, tmp[k][j]);
                    area = Math.max(area, (i-k+1)* width);
                }
                result = Math.max(area, result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        char[][] c = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] c = {{'0','1'},{'0','1'}};

        Solution85 solution85 = new Solution85();
        solution85.maximalRectangle(c);
    }
}
