package solution.solution_other;

import java.util.*;

public class CountOfSmallerNumbersAfterSelf {
//    public List<Integer> countSmaller(int[] nums) {
//        Map<Integer , List<Integer>> map = new HashMap<>();
//        for (int i =0 ; i<nums.length ; i++){
//            int currentNum = nums[i];
//            if (!map.containsKey(currentNum)){
//                List<Integer> l = new ArrayList<>();
//                l.add(i);
//                map.put(currentNum, l);
//            }else {
//                map.get(currentNum).add(i);
//            }
//        }
//
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0 ; i<nums.length; i++){
//            Integer currentNumber = nums[i];
//            Integer count = 0;
//            for (Integer numInMap : map.keySet()){
//                if(numInMap < currentNumber){
//                    List<Integer> l = map.get(numInMap);
//                    for(int j = 0 ; j < l.size(); j++){
//                        if (l.get(j)>i){
//                            count = count + l.size() - j ;
//                            break;
//                        }
//                    }
//
//                }
//            }
//            result.add(count);
//        }
//        return  result;
//    }

    public List<Integer> countSmaller(int[] nums) {
        // 组装桶的下标数组a，按从小到大顺序存储numbs中出现过的数字
        Set<Integer> set = new HashSet<>();
        for(Integer i : nums){
            set.add(i);
        }
        int[] a = new int[set.size()];
        int index = 0;
        for (Integer i : set){
            a[index] = i;
            index++;
        }
        Arrays.sort(a);
        // 桶数组，下标与a一一对应，存储数字出现次数，初始化为0
        int[] barrel = new int[set.size()];
        Arrays.fill(barrel, 0);
        // 结果数组
        int[] result = new int[nums.length];
        Arrays.fill(result, 0);
        //从nums右向左计算
        for(int i = nums.length-1;i>=0;i--){
            int currentNum = nums[i];
            // 到下标数组a中找到下标index
            index = Arrays.binarySearch(a, currentNum);
            // 找到桶数组中，在index左侧的值，并求和
            for(int j = 0; j < index; j++){
                result[i] = result[i] + barrel[j];
            }
            // 求和结果是比index下标小的数字的出现次数
            // 同时将index下标的值加1，即nums[i]出现了一次
            barrel[index] = barrel[index] + 1;
        }

        List<Integer> resultL = new ArrayList<>();
        for(int i = 0; i<nums.length;i++){
            resultL.add(result[i]);
        }
        return  resultL;
    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf countOfSmallerNumbersAfterSelf = new CountOfSmallerNumbersAfterSelf();
        int[] aa = {5,2,6,1};
//        int[][] aaa = {{0,-3}};
        List<Integer> result = countOfSmallerNumbersAfterSelf.countSmaller(aa);
        for (Integer i : result){
            System.out.println(i);

        }
    }
}
