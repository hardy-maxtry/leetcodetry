package solution.solution1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++){
            if(first > 0 && nums[first] == nums[first-1]){
                continue;
            }

            int third = nums.length - 1;
            for (int second = first+1; second< third; second ++){
                if (second > first+1 && nums[second] == nums[second-1]){
                    continue;
                }

                while (third>second && nums[first] + nums[second] + nums[third] > 0){
                    third --;
                }

                if (third == second){
                    break;
                }
                if (nums[first] + nums[second] + nums[third] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] origin =  {-1, 0, 1, 2, -1, -4};
        Solution15 solution15 = new Solution15();
        List<List<Integer>> result = solution15.threeSum(origin);
        for (List<Integer> r : result){
            for (Integer i : r){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
