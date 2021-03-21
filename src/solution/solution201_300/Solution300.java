package solution.solution201_300;

import java.util.Arrays;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] tmpArr = new int[nums.length];

        Arrays.fill(tmpArr, 1);
        int result = 1;
        for (int i = 1; i < nums.length; i++){
            for (int j = i; j >=0; j--){
                if (nums[i] > nums[j]){
                    tmpArr[i] = Math.max(tmpArr[i], tmpArr[j]+1);
                    result = Math.max(result, tmpArr[i]);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution300 solution300 = new Solution300();
        int[] input = {0,1,0,3,2,3};
        solution300.lengthOfLIS(input);
    }
}
