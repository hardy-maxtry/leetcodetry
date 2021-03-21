package solution.solution901_1000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();

        for (int i = A.length-1; i >= 0;i--){
            int sum = A[i] + K % 10;
            K = K / 10;
            if (sum >= 10){
                K++;
                sum = sum-10;
            }
            result.add(sum);
        }
        while(K>0){
            result.add(K%10);
            K = K / 10;
        }
        Collections.reverse(result);
        return result;
    }
}
