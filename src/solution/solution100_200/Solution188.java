package solution.solution100_200;

import java.util.Arrays;

public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        // 第i天，进行k次操作时，手中持有股票的最大收益值
        int[][] buy = new int[n][k + 1];
        // 第i天，进行k次操作时，手中不持有股票的最大收益值
        int[][] sell = new int[n][k + 1];


        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        // 初始化最小值
        for (int i = 1; i <= k; ++i) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }
        // i是总天数
        for (int i = 1; i < prices.length; i++){
            // 第i天，0次交易初始化收益
            buy[i][0] = Math.max(buy[i-1][0], sell[i-1][0] - prices[i]);
            // j 是交易次数，注意这里不一定要完成完整的k次交易，可以少于k次获取最大值
            for (int j = 1; j <= k; j++){
                // 第i天，有j次交易，最大化收益
                // 如果当天持有股票，那么最大收益=前一天已经持有股票且当天不操作，或前一天不持有股票并且当天买入，两者的较大值
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                // 如果当天不持有股票，那么最大收益=前一天不持有股票且当天不操作，或者前一天持有股票且当天卖出股票，两者的较大值
                // 注意，只有卖出股票的操作，才将交易次数+1，所以才有buy[i - 1][j - 1] + prices[i]
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        // 最大收益一定出现在，手中不持有股票即全部抛出的情况
        // 找到最后一天，经历了不超过k次交易的所有情况中，最大收益的那一个，即是答案
        return Arrays.stream(sell[n-1]).max().getAsInt();
    }
}
