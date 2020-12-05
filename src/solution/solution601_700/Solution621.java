package solution.solution601_700;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        if(n==0){return tasks.length;}
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        // 最多的执行次数
        int maxExec = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxExec = Math.max(maxExec, exec);
        }
        // maxExec数量的任务，为了n出现次数最少，那么这样的任务一定出现在头尾，尾部即为maxCount
        // 组成矩阵，每一行由次数等于maxExec的任务，外加剩余任务组成
        // 每一行的任务数量是  n + 1，也就是一个任务，加间隔数量，此处先认定N是一个比较大的值，每一行的N一能放得下所有不重复任务，记为情况一，
        // 但是，当N很小时，如果每一行任务很多，由于任务间隔排列，则一定不会触发N导致强制等待的情况，因此最终时间长度等于数组长度
        // 最后的结果 = (maxExec数量 - 1) * (n + 1) + maxCount
        // maxCount具有最多执行次数的任务数量
        // 将会累加在总次数尾部
        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {

            int value = entry.getValue();
            if (value == maxExec) {
                ++maxCount;
            }
        }

        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);

    }
}
