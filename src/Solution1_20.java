import java.util.HashMap;
import java.util.Map;

public class Solution1_20 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length;  i++){

            Integer otherInt = target - nums[i];
            if(map.containsKey(otherInt) && map.get(otherInt) != i){
                return new int[]{i, map.get(otherInt)};
            }else if(map.containsKey(otherInt) && otherInt == nums[i]){
                return new int[]{ map.get(otherInt), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two Nums matched");
    }
}
