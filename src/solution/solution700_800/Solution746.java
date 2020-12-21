package solution.solution700_800;

public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        // dp[i] 指 走到第i格，之前所有的消耗综合，只有离开了当前格子i，才将当前格的消耗cost[i]加入总消耗计算
        // 因此 dp[0] 是从起点跨1格走到cost[0]，还没有产生消耗，只有从cost[0]继续向后走，才会计算 cost[0]的消耗
        // 由于每次可以跨2格，因此 dp[1] 是从起点跨2格走到cost[1]，还没有产生消耗，只有从cost[1]继续向后走，才会计算 cost[1]的消耗
        int[] dp = new int[cost.length+1];

        for (int i = 2;i < cost.length+1; i++){
            dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1]+ cost[i-1]);
        }
        return dp[cost.length];

    }

    public static void main(String[] args){
        Solution746 solution746 = new Solution746();
        int[] i = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(solution746.minCostClimbingStairs(i));
    }
}
