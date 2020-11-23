package solution.solution401_500;

import java.util.Arrays;
import java.util.Comparator;

public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length ==0){
            return 0;
        }
        if (points.length == 1){
            return 1;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int left = points[0][0];
        int right = points[0][1];
        int result = 1;
        for (int i = 1; i< points.length ; i++){
            left = Math.max(left, points[i][0]);
            right = Math.min(right, points[i][1]);
            if (left > right){
                result ++;
                right = points[i][1];
            }
        }
        return result;
    }


    public static void main(String[] args) {
//        int[][] points =  {{10,16},{2,8},{1,6},{7,12}};
//        int[][] points = {{1,2},{3,4},{5,6},{7,8}};
        int[][] points = {{1,2},{2,3},{3,4},{4,5}};
        Solution452 solution452 = new Solution452();
        System.out.println(solution452.findMinArrowShots(points));


    }

}
