package solution.solution501_600;

public class Solution566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r*c){
            return nums;
        }

        int[][] result = new int[r][c];
        int tmpR = 0;
        int tmpC = 0;
        for (int i = 0; i < nums.length;i++){
            for (int j = 0; j < nums[0].length; j++){
                result[tmpR][tmpC] = nums[i][j];
                if (tmpC == c-1){
                    tmpR++;
                    tmpC = 0;
                }else {
                    tmpC++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] in = {{1,2},{3,4}};
        Solution566 solution566 = new Solution566();
        System.out.println(solution566.matrixReshape(in, 1,4));
    }
}
