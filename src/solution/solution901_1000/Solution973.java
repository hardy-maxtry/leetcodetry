package solution.solution901_1000;

import java.util.Arrays;
import java.util.Comparator;

public class Solution973 {
    public int[][] kClosest(int[][] points, int K) {

        Arrays.sort(points, Comparator.comparing((int[] x)->{
            return x[0] *x[0] + x[1]*x[1];
        }));

        return Arrays.copyOfRange(points, 0, K);

    }
}
