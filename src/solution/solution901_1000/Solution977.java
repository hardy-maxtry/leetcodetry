package solution.solution901_1000;

import java.util.Arrays;

public class Solution977 {

    /** 冒泡
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];
        for(int i=0; i < A.length ; i ++){
            B[i] = A[i] * A[i];
        }
        Arrays.sort(B);
        return B;
    }

    public int[] sortedSquares2(int[] A) {
        if (A.length == 0){
            return A;
        }
        int[] B = new int[A.length];

        int i = 0;
        int j = A.length - 1;
        int pos = A.length - 1;
        while (i <= j){
            if (A[i] * A[i] > A[j] * A[j]){
                B[pos] = A[i] * A[i];
                i++;
            }else{
                B[pos] = A[j] * A[j];
                j --;
            }
            pos --;
        }

        return B;
    }

    public static void main(String args[]){
        int[] arr = new int[]{-4,-1,0,3,10};
        int[] arr2 = new int[]{-7,-3,2,3,11};
        int[] arr3 = new int[]{};
        int[] arr4 = new int[]{-4,3};
        Solution977 solution977 = new Solution977();
        int[] result = solution977.sortedSquares(arr);
        int[] result2 = solution977.sortedSquares(arr2);
        int[] result3 = solution977.sortedSquares(arr3);
        int[] result4 = solution977.sortedSquares(arr4);
        System.out.println(result);

    }
}
