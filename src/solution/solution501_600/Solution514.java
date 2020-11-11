package solution.solution501_600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution514 {
    public int findRotateSteps(String ring, String key) {
        Map<Character, List<Integer>> charPosMap = new HashMap<>();
        for(int i= 0; i < ring.length(); i++){
            Character c = ring.charAt(i);
            if (!charPosMap.containsKey(c)){
                charPosMap.put(c, new ArrayList<>());
            }
            charPosMap.get(c).add(i);
        }
        int currentPos = 0;
        int result = 0;

        // 转动记录存储的是 [ 位置, 步数 ]
        // 每转动到指定target字母时，都进行一次计算，保存转动到target指定字母的位置，和使用的步数，该步数需要和上一次转动累计步数做相加
        List<Integer[]> path0 = new ArrayList<>(); // 上一次转动记录
        List<Integer[]> path1 = new ArrayList<>(); // 本次转动记录
        List<Integer[]> tmp = new ArrayList<>();
        // 初始化，12点指向字符串下标0的位置
        path0.add(new Integer[]{0,0});

        int minCost = Integer.MAX_VALUE;
        for (Character ckey : key.toCharArray()){
            Character currentChar = ring.charAt(currentPos);

            for(Integer pos : charPosMap.get(ckey)){
                int cost = Integer.MAX_VALUE;
                for (Integer[] arr : path0){
                    int lastPos = arr[0]; // 上一次转动结束位置
                    int cost1 = Math.abs(pos - lastPos);   // 从上一次转动结束位置 转动到 本次字母的位置之一 的消耗 // 顺时针
                    int cost2 = ring.length() - cost1;  // 从上一次转动结束位置 转动到 本次字母的位置之一 的消耗 // 逆时针 这里顺时针逆时针没有强求，只是方向不同而已
                    int tmpcost =  Math.min(cost1, cost2); // 本次挪动最少距离
                    cost = Math.min(cost, tmpcost + arr[1]); // 本次挪动最少距离+上次已累计的距离
                }
                path1.add(new Integer[]{pos, cost});
            }
            path0 = path1; tmp = path1; path1 = new ArrayList<>();

        }
        for (Integer[] arr: tmp){
            minCost = Math.min(minCost, arr[1]);
        }

        return  minCost + key.length();
    }

    public static void main(String[] args){
        Solution514 solution514 = new Solution514();
        solution514.findRotateSteps("aaaaab", "aaaab");
    }
}
