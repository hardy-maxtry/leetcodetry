package solution.solution100_200;

public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        for (int i = 0; i < gas.length; i++){
            // 初始油量为当前油站提供的补给
            int remainGas = gas[i];
            int j = i;
            // 计算油量大于当前路程所需油耗
            while(remainGas >= cost[j]){
                // 实际上是一个圆，需要考虑超出gas长度下标回到0的情况
                int nextPos = (j + 1) % gas.length;
                // 剩余汽油为 油量-油耗+下一油站补给
                remainGas = remainGas - cost[j] + gas[nextPos];
                if (nextPos == i){
                    // 下标转了一圈回来
                    return i;
                }
                j = nextPos;
            }
            if (j < i){
                // 循环到了这样一种情况
                // 例如length=6, i=3, 转了一圈回来 j = 1
                // 可知如下
                // 1. 因为i已经经过了0,1,2，这三个点出发都不能回到起点
                // 2. 下一个出发点是本次的结束点+1, (参考下面i=j的逻辑)
                // 由上述两点，可知不存在能回到起点的情况
                return -1;
            }
            // 例如从i=0出发, 在j=3时，不能继续下一站
            // 因此从 i=1,2出发，也不可能超过j=3
            i = j; // 直接跳到j+1 出发，for循环自带 i++ ，这里直接赋值 i=j即可
        }
        return -1;
    }

    public static void main(String[] args){
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        Solution134 solution134 = new Solution134();
        System.out.println(solution134.canCompleteCircuit(gas, cost));
    }
}
