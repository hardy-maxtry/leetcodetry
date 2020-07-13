package solution.solution_other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = this.buildMap(nums1);
        Map<Integer, Integer> map2 = this.buildMap(nums2);
        List<Integer> arr = new ArrayList<>();
        for (Integer key : map1.keySet()){
            if (map2.containsKey(key)){
                if (map2.get(key) >= map1.get(key)){
                    for (int i = 0; i < map1.get(key); i ++){
                        arr.add(key);
                    }
                }else{
                    for (int i = 0; i < map2.get(key); i ++){
                        arr.add(key);
                    }
                }
            }
        }
        int[] result = new int[arr.size()];
        int index = 0;
        for (Integer i : arr){
            result[index] = i;
            index++;
        }
        return result;
    }

    public Map<Integer, Integer> buildMap(int[] nums){
        HashMap<Integer, Integer> result = new HashMap<>();
        for(Integer i : nums){
            if (!result.containsKey(i)){
                result.put(i , 1);
            }else {
                result.put(i, result.get(i)+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysII intersectionOfTwoArraysII = new IntersectionOfTwoArraysII();
        int[] a = {1,2,2,1};
        int[] b = {2,2};
        int[] result = intersectionOfTwoArraysII.intersect(a, b);
        for (int i : result) {
            System.out.println(i);
        }

    }
}
