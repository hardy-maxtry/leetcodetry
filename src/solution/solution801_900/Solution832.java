package solution.solution801_900;

public class Solution832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int columns = A[0].length;
        int mid = columns / 2;
        boolean isEven = columns % 2 == 0;
        for (int i = 0 ; i < A.length ; i ++){
            for (int j = 0; j < columns; j ++){
                if (j < mid){
                    int left = A[i][j] ^ 1;
                    int right = A[i][columns - j - 1] ^ 1;
                    A[i][j] = right;
                    A[i][columns - j - 1] = left;
                }else if (j == mid){
                    if (isEven){
                        continue;
                    }else{
                        A[i][j] ^= 1;
                    }
                }else{
                    continue;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] A = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        Solution832 solution832 = new Solution832();
        System.out.println(solution832.flipAndInvertImage(A));
    }
}
