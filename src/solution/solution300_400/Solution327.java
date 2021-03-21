package solution.solution300_400;

import java.util.Arrays;

public class Solution327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long dp = 0L;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                dp = j == i ? nums[i] : dp + nums[j];
//                if (dp >= lower && dp <= upper){
//                    result++;
//                }
                if (dp >= lower && dp <= upper){
                    result++;
                }else if(dp < lower){
                    continue;
                }else{
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution327 solution327 = new Solution327();

        solution327.countRangeSum(new int[]{2147483647,-2147483648,-1,0}, -1, 0);
//        solution327.countRangeSum(new int[]{-2,5,-1}, -2, 2);
    }
}
