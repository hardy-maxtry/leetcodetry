package solution.solution201_300;

import java.util.ArrayList;
import java.util.List;

public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0){
            return new ArrayList<>();
        }
        if (nums.length == 1){
            List<String> result = new ArrayList<>();
            result.add(String.valueOf(nums[0]));
            return result;
        }
        int start = nums[0], end = nums[0];
        List<String> result = new ArrayList<>();
        for (int i = 1; i < nums.length; i ++){
            int tmp = nums[i];
            if (tmp == nums[i-1]+1){
                end = tmp;
            }else{
                if (start == end){
                    result.add(Integer.toString(start) );
                }else{
                    result.add(start +"->"+ end);
                }
                start = tmp;
                end =  tmp;
            }
        }
        if (start == end){
            result.add(Integer.toString(start) );
        }else{
            result.add(start +"->"+ end);
        }
        return result;
    }
}
