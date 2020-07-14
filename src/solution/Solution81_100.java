package solution;

public class Solution81_100 {
    // id 96
    public int numTrees(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        // resultArray存储的是，n个数字组成的搜索二叉树的个数
        int[] resultArray = new int[n+1];
        resultArray[0] = 1;
        resultArray[1] = 1;
        for(int i=2; i < n + 1; i++){
            int current = 0;
            // 遍历从1到i不同数字作为根节点，有多少种可能性
            for (int j = 1; j < i+1 ; j++){
                // 左侧树和右侧树所有可能性，实际上是个笛卡儿积
                // 因此数量直接相乘
                // 左子树和右子树的可能性，由于都没有重复数字，因此与具体数值无关，只与数字的个数有关
                current += resultArray[j-1] * resultArray[i-j];
            }
            resultArray[i] = current;
        }
        return resultArray[n];
    }
    public static void main(String[] args){
        Solution81_100 solution81_100 = new Solution81_100();
        System.out.println(solution81_100.numTrees(3));
    }
}
