package solution.solution1001_1100;

public class Solution1004 {
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;
        int countOfZero = 0;
        int result = 0;
        while(right < A.length){
            while (countOfZero <= K && right < A.length){
                if (A[right] == 0){
                    countOfZero++;
                }
                right++;
            }
            if (countOfZero > K){
                result = Math.max(right - left - 1, result);
            }else{
                result = Math.max(right - left, result);
            }
            while(countOfZero > K && right>=left){
                if (A[left] == 0){
                    countOfZero--;
                }
                left++;
            }
        }
        result = Math.max(right - left - 1, result);
        return result;
    }

    public static void main(String[] args) {
        Solution1004 solution1004 = new Solution1004();
//        int[] input = {1,1,1,0,0,0,1,1,1,1,0};
//        int K = 2;
//        int[] input = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
//        int K = 3;
        int[] input = {0,0,0,1};
        int K = 4;
        System.out.println(solution1004.longestOnes(input, K));
    }
}
