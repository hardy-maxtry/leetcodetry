package solution.solution1001_1100;

import java.util.HashMap;
import java.util.Map;

public class Solution1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int[] d : dominoes){
            int tmp = d[0] < d[1] ? d[1] * 10 + d[0] : d[0] * 10 + d[1];
            if (map.containsKey(tmp)){
                count = count + map.get(tmp);
                map.put(tmp, map.get(tmp)+1);
            }else{
                map.put(tmp, 1);
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[][] a = {{1,2},{1,2},{1,1},{1,2},{2,2}};
        Solution1128 solution1128 = new Solution1128();
        solution1128.numEquivDominoPairs(a);
    }

}
