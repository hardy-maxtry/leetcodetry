package solution.solution1_100;

import java.util.ArrayList;
import java.util.List;

public class Solution57 {
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        List<Integer[]> resultList = new ArrayList<>();
//        boolean newIntervalUsed = false;
//
//        if (newInterval[1] <= intervals[0][0]){
//            if (newInterval[1] < intervals[0][0] - 1){
//                int[][] result = new int[intervals.length][2];
//                result[0] = newInterval;
//                for (int i = 1; i < result.length; i++){
//                    result[i] = intervals[i-1];
//                }
//                return result;
//            }else{
//                intervals[0][0] = newInterval[0];
//                return intervals;
//            }
//        }
//        for (int i = 0; i< intervals.length ;i++){
//            int[] interval = intervals[i];
//            // 某个分段 完全覆盖 新分段
//            if (interval[0] <=  newInterval[0] && interval[1] >= newInterval[1]){
//                return intervals;
//            }
//            // 某个分段 覆盖了 新分段的左半部分
//            if (interval[0] <  newInterval[0] && interval[1] >= newInterval[0] && interval[1]<=newInterval[1]){
//                resultList.add(new Integer[]{interval[0],newInterval[1]});
//                newIntervalUsed = true;
//                continue;
//            }
//
//            // 某个分段 在 新分段 内部
//            if (interval[0] >  newInterval[0] && interval[1] < newInterval[1]){
//                if (newIntervalUsed){
//                    continue;
//                }else{
//                    resultList.add(new Integer[]{newInterval[0], newInterval[1]});
//                    newIntervalUsed = true;
//                    continue;
//                }
//            }
//
//            // 某个分段 覆盖了 新分段的有半部分
//            if (interval[0] > newInterval[0] && interval[1] >= newInterval[1] && interval[0] < newInterval[1]){
//                if (newIntervalUsed){
//                    continue;
//                }else{
//                    resultList.add(new Integer[]{newInterval[0], interval[1]});
//                    newIntervalUsed = true;
//                    continue;
//                }
//            }
//
//            // 新分段在两个旧分段之间
//            if (i > 0 && newInterval[0] > intervals[i-1][1] && newInterval[1] < intervals[i][0]){
//                if (newInterval[0] > intervals[i-1][1]+1 && newInterval[1] < intervals[i][0]-1){
//                    resultList.add(new Integer[]{newInterval[0], newInterval[1]});
//                    resultList.add(new Integer[]{interval[0], interval[1]});
//                }
//                if(newInterval[0] == intervals[i-1][1]+1 && newInterval[1] < intervals[i][0]-1){
//                    resultList.get(resultList.size()-1)[1] = newInterval[1];
//                }
//                if(newInterval[0] > intervals[i-1][1]+1 && newInterval[1] == intervals[i][0]-1){
//                    resultList.add(new Integer[]{newInterval[0], intervals[1][1]});
//                }
//                continue;
//
//            }
//
//        }
//
//        int[][] result2 = new int[resultList.size()][2];
//        for (int i = 0; i < resultList.size() ; i++){
//            Integer[] tmp = resultList.get(i);
//            result2[i] = new int[]{tmp[0], tmp[1]};
//        }
//        return result2;
//    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0){
            return new int[][]{newInterval};
        }
        List<int[]> resultList = new ArrayList<>();
        boolean newIntervalUsed = false;
        // 左边界
        if (newInterval[1] <= intervals[0][0]){
            if (newInterval[1] < intervals[0][0] ){
                int[][] result = new int[intervals.length+1][2];
                result[0] = newInterval;
                for (int i = 1; i < result.length; i++){
                    result[i] = intervals[i-1];
                }
                return result;
            }else{
                intervals[0][0] = newInterval[0];
                return intervals;
            }
        }

        // 右边界
        if(newInterval[0] >= intervals[intervals.length-1][1]){
            if (newInterval[0] > intervals[intervals.length-1][1] ){
                int[][] result = new int[intervals.length+1][2];
                for (int i = 0; i < result.length-1; i++){
                    result[i] = intervals[i];
                }
                result[result.length-1] = newInterval;

                return result;
            }else{
                intervals[intervals.length-1][1] = newInterval[1];
                return intervals;
            }
        }

        for (int i = 0; i < intervals.length; i++){
            int[] interval = intervals[i];
            if (!newIntervalUsed){
                // 不交叉，newInterval在当前分段左侧
                if (newInterval[1] < interval[0]){
                    resultList.add(newInterval);
                    resultList.add(interval);
                    newIntervalUsed = true;
                    continue;
                }

                // 交叉
                if ((newInterval[0] >= interval[0] && newInterval[0]  <= interval[1] )
                        || (newInterval[1] >= interval[0] && newInterval[1]  <= interval[1] ) ){
                    resultList.add(new int[]{Math.min(newInterval[0], interval[0]), Math.max(newInterval[1], interval[1])});
                    newIntervalUsed = true;
                    continue;
                }
                // 包含
                if ((newInterval[0] <= interval[0] && newInterval[1]  >= interval[1] )
                ){
                resultList.add(newInterval);
                    newIntervalUsed = true;
                    continue;
                }
                // 右侧不考虑 留给下一个循环

                resultList.add(interval);
                continue;
            }

            int[] intervalPrev = resultList.get(resultList.size()-1);
            // 与上一个分段结果交叉
            if ((intervalPrev[0] >= interval[0] && intervalPrev[0]  <= interval[1] )
                    || (intervalPrev[1] >= interval[0] && intervalPrev[1]  <= interval[1] ) ){
                resultList.get(resultList.size()-1)[1] = Math.max(intervalPrev[1], interval[1]);
//                resultList.add(new int[]{Math.min(intervalPrev[0], interval[0]), Math.max(intervalPrev[1], interval[1])});
                continue;
            }
            // 上一分段包含本分段
            if ((intervalPrev[0] <= interval[0] && intervalPrev[1]  >= interval[1] )
                     ){
//                resultList.add(new int[]{Math.min(intervalPrev[0], interval[0]), Math.max(intervalPrev[1], interval[1])});
                continue;
            }
            // 与上一分段结果不交叉
            resultList.add(interval);


        }
        int[][] result2 = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size() ; i++){
            result2[i] = resultList.get(i);
        }
        return result2;
    }


    public static void main(String[] args){
        int[][] a = new int[][]{{1,5},{6,8}};
        int[] b = new int[]{8,9};
//        int[] b = new int[]{0,9};

//        int[][] a = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int[] b = new int[]{4,8};
        Solution57 solution57 = new Solution57();
        solution57.insert(a,b);

    }
}
