package solution.solution300_400;

import java.util.*;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();
        for (Integer i : nums1){
            nums1Set.add(i);
        }
        for (Integer i : nums2){
            nums2Set.add(i);
        }

        List<Integer> nums1List = new ArrayList<>(nums1Set);
        List<Integer> nums2List = new ArrayList<>(nums2Set);
        nums1List.sort((x,y)->{
            return x.compareTo(y);
        });
        nums2List.sort((x,y)->{
            return x.compareTo(y);
        });

        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums1List.size() && j < nums2List.size()){
            if (nums1List.get(i).equals(nums2List.get(j))){
                result.add(nums1List.get(i));
                i++;
                j++;
            }else{
                if (nums1List.get(i) < nums2List.get(j)){
                    i++;
                }else{
                    j++;
                }
            }
        }

        int[] r = new int[result.size()];
        for ( i = 0 ; i < result.size(); i ++){
            r[i] = result.get(i);
        }
        return r;

    }

    public int[] intersection2(int[] nums1, int[] nums2) {

        // 排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);


        // 双指针
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] ==(nums2[j])){
                // 去除重复数字
                if (i>0 && j >0){
                    if (nums1[i] == nums1[i-1] ){
                        i++;
                        continue;
                    }
                    if (nums2[j] == nums2[j-1]){
                        j++;
                        continue;
                    }

                }
                result.add(nums1[i]);
                i++;
                j++;
            }else{
                if (nums1[i]< nums2[j]){
                    i++;
                }else{
                    j++;
                }
            }
        }

        int[] r = new int[result.size()];
        for ( i = 0 ; i < result.size(); i ++){
            r[i] = result.get(i);
        }
        return r;

    }
}
