package solution.solution601_700;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        if(k > nums.length){
            return Arrays.stream(nums).mapToDouble(x->(double)x).average().getAsDouble();
        }
        int left = 0;
        int right = k-1;
        int maxSum = 0;
        for (int i = 0 ; i < k; i++){
            maxSum+=nums[i];
        }
        int tmpSum = maxSum;
        for(int i = 1 ; i < nums.length - k; i++){
            tmpSum = tmpSum - nums[i-1] + nums[i+k-1];
            maxSum = Math.max(tmpSum, maxSum);
        }

        return (double)(maxSum) / k;
    }

    public static void main(String[] args) {
//        int[] in = {1,12,-5,-6,50,3};
        int[] in = {0,1,1,3,3};
        Solution643 solution643 = new Solution643();
        System.out.println(solution643.findMaxAverage(in, 4));;
    }
}
