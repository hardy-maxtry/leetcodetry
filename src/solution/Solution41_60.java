package solution;

public class Solution41_60 {
    public int maximum_subarray(int[] nums) {
        int result = nums[0];
        int current = 0;
        for(int i = 0; i < nums.length; i++){
            if(current > 0){
                current += nums[i];
            }else{
                current = nums[i];
            }
            result = Math.max(result , current);
        }
        return result;
    }

    public int maximum_subarray2(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        int start = 0;
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            if(dp[i-1] + nums[i] < nums[i]){
                start = i;
            }
        }
        int result = nums[0];
        int end = 0;
        for(int i = 1; i < dp.length ; i ++){
            result = Math.max(result, dp[i]);
            if(dp[i-1] < dp[i]){
                end = i;
            }
        }

        return result;
    }
}
