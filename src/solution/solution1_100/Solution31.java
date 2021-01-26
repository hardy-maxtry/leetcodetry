package solution.solution1_100;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution31 {
    public void nextPermutation(int[] nums) {
        boolean found = false;
        int i = nums.length-1;
        for(; i>0; i--){
            if (nums[i-1] < nums[i] ){
                found = true;
                break;
            }
        }
        if (!found){
            Arrays.sort(nums);
            return;
        }

        int left = nums[i-1];

        int biggerNum = Integer.MAX_VALUE;
        int j = i;
        int right = -1;
        for(;j<nums.length; j++){
            if (nums[j]>left && nums[j] < biggerNum){
                biggerNum = nums[j];
                right = j;
            }
        }

        int tmp = nums[right];
        nums[right] = nums[i-1];
        nums[i-1] = tmp;
        Arrays.sort(nums, i, nums.length);



    }

    public static void main(String[] args){
        Solution31 solution31 = new Solution31();
//        int[] a = new int[]{1,2,3};
        //int[] a = new int[]{3,2,1};
        int [] a = new int[]{2,3,1};
        solution31.nextPermutation(a);
        System.out.println(a);
    }

}
