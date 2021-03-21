package solution.solution300_400;

public class Solution304 {
    private int[][] matrix;
    private int[][] sumMatrix;
    private int countOfRow;
    private int countOfColumn;

    public Solution304(int[][] matrix) {
        this.matrix = matrix;

        if (matrix.length > 0 && matrix[0].length > 0){
            this.countOfRow  = matrix.length;
            this.countOfColumn = matrix[0].length;
            this.sumMatrix = new int[countOfRow][countOfColumn];
            this.calcSum();
        }


    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0){
            return this.sumMatrix[row2][col2];
        }else if (row1 == 0){
            return this.sumMatrix[row2][col2] - this.sumMatrix[row2][col1-1];
        }else if (col1 == 0){
            return this.sumMatrix[row2][col2] - this.sumMatrix[row1-1][col2];
        }else{
            return this.sumMatrix[row2][col2] - this.sumMatrix[row1-1][col2] - this.sumMatrix[row2][col1-1] + this.sumMatrix[row1-1][col1-1];
        }
    }

    private void calcSum(){
        for (int i = 0; i < countOfRow; i++){
            for (int j = 0; j < countOfColumn; j++){
                if (i==0 && j == 0){
                    this.sumMatrix[i][j] = this.matrix[i][j];
                }else if (i==0){
                    this.sumMatrix[i][j] = this.sumMatrix[i][j-1] + this.matrix[i][j];
                }else if(j == 0){
                    this.sumMatrix[i][j] = this.sumMatrix[i-1][j] + this.matrix[i][j];
                }else{
                    this.sumMatrix[i][j] = this.sumMatrix[i][j-1] + this.sumMatrix[i-1][j] + this.matrix[i][j] - this.sumMatrix[i-1][j-1];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] aaa = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        Solution304 solution304 = new Solution304(aaa);
        solution304.sumRegion(2,1,4,3);
//        {2,1,4,3},{1,1,2,2},{1,2,2,4}};

    }

}
