package solution.solution201_300;

import java.util.HashSet;
import java.util.Set;

public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set set = new HashSet<Integer>();
        for (int num : nums){
            if (set.contains(new Integer(num))){
                return true;
            }
            set.add(new Integer(num));
        }
        return false;

    }
}
