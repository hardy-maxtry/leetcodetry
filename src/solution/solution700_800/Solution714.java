package solution.solution700_800;

public class Solution714 {
    // 参考了官方题解
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // 只能购买一只股票，不能叠加购买
        // 因此只考虑持仓和空仓状态，其中持仓表示在下一次卖出前只允许购买一次
        dp[0][0] = 0; // 空仓状态
        dp[0][1] = -prices[0]; // 持仓状态
        for (int i = 1; i < n; ++i) {
            // 保持空仓状态，或者上一个持仓在本次卖出后，大于上一次就卖出导致空仓状态的收益
            // 当股价下降时，本次卖出的收益，一定小于上一次卖出的收益
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            // 保持持仓状态，或者上一次空仓在本次买入后，大于上一次就买入导致持仓的状态的收益
            // 当股价上涨时，本次购入的收益一定小于上一次购入的收益
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
