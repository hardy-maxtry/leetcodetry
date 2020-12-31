package solution.solution401_500;

import solution.solution1_100.Solution43;

import java.util.Arrays;
import java.util.Comparator;

public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0){
            return 0;
        }
        // 右端点从小到达排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int length = intervals.length;
        int count = 0;
        // 取排序后数组，第一条线段右端点，代入运算
        int tmpRight = intervals[0][1];
        // 遍历排序后数组
        for (int i = 1; i < length; i++){
            if (intervals[i][0] < tmpRight){
                // 如果当前线段左端点，小于之前线段的右端点，则说明重复，需要排除
                count++;
            }else{
                // 如果当前线段左端点，大于等于之前线段的右端点，则说明不重复，取这个线段的右端点(即已经排除之前的重复线段)，代入继续运算
                tmpRight = intervals[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[][] input = { {1,2}, {2,3}, {3,4}, {1,3} };
        int[][] input = { {1,2}, {1,2}, {1,2}, {1,3} };
        Solution435 solution435 = new Solution435();
        int r = solution435.eraseOverlapIntervals(input);
        System.out.println(r);
    }
}
