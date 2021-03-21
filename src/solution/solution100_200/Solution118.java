package solution.solution100_200;

import solution.solution1_100.Solution34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0){
            return result;
        }
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        result.add(row1);
        if (numRows == 1){
            return result;
        }
        List<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);
        result.add(row2);
        if (numRows == 2){
            return result;
        }

        for (int i=2; i<numRows; i++){
            Integer[] tmpRowArr = new Integer[i+1];
            tmpRowArr[0] = 1;
            tmpRowArr[i] = 1;
            for (int j = 1; j < i ; j++){
                tmpRowArr[j] = result.get(i-1).get(j-1) + result.get(i-1).get(j);
            }
            List<Integer> tmpRow = Arrays.asList(tmpRowArr);
            result.add(tmpRow);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution118 solution118 = new Solution118();
        solution118.generate(5);
    }
}
