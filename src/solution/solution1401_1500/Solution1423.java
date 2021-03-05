package solution.solution1401_1500;

import java.util.Arrays;

public class Solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        int sum = Arrays.stream(cardPoints).sum();
        int tmpResult = 0;
        int tmpLength = cardPoints.length - k;
        for (int i = 0; i < tmpLength; i ++){
            tmpResult+=cardPoints[i];
        }
        int minValue = tmpResult;
        for (int i = 1; i + tmpLength - 1< cardPoints.length ; i ++){
            tmpResult = tmpResult - cardPoints[i-1] + cardPoints[i+tmpLength-1];
            minValue = Math.min(minValue, tmpResult);
        }
        return sum - minValue;
    }

    public static void main(String[] args) {
        Solution1423 solution1423 = new Solution1423();
        int[] cardPoints = {100,40,17,9,73,75};
        System.out.println(solution1423.maxScore(cardPoints, 3));
    }
}
