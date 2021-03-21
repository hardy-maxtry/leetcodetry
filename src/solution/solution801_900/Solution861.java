package solution.solution801_900;

public class Solution861 {
    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++){
            if (A[i][0] == 0){
                for (int j = 0; j < A[i].length; j++){
                    A[i][j] = 1 - A[i][j];
                }
            }
        }

        for (int i = 1; i < A[0].length; i++){
            int countOf1 = 0;
            int countOf0 = 0;
            for (int j = 0; j < A.length; j ++){
                countOf0 = countOf0 + (A[j][i] == 0 ? 1 : 0);
                countOf1 = countOf1 + (A[j][i] == 1 ? 1 : 0);
            }
            if (countOf0 > countOf1){
                for (int j = 0; j < A.length; j ++){
                    A[j][i] = 1 - A[j][i];
                }
            }
        }
        int res = 0;
        for (int[] a : A) {
            int score = 0;
            for (int num : a) {
                score = score * 2 + num;
            }
            res += score;
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] A = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        Solution861 solution861 = new Solution861();
        System.out.println(solution861.matrixScore(A));
    }
}
