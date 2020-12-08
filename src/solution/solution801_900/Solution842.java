package solution.solution801_900;

import java.util.ArrayList;
import java.util.List;

public class Solution842 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new ArrayList<>();
        dfs(S.toCharArray(), result, 0);
        return  result;
    }

    // 从第index个数字开始，获取数字，并与之前结果进行比较
    public boolean dfs(char[] chars, List<Integer> res, int index){
        // 遍历最后一位成功后，才会走到这里，同时如果res.size>=3 说明斐波那契成立
        // 这里实际上会走到47行
        if (index == chars.length && res.size() >= 3){
            return true;
        }

        for (int i = index; i < chars.length; i++){
            if (chars[index] == '0' && i > index){
                break;
            }
            // 从当前位数开始，获取下一个数字
            long num = getDigit(chars, index, i+1);
            // 超过 2^32 -1 则不进行计算
            if (num > Integer.MAX_VALUE){
                break;
            }
            // 获取当前结果集长度
            int resultSize = res.size();
            // 结果集数量>=2，需要判断斐波那契性质
            // num 大于前两个数字，则i向后增加数位，也一定大于前两个数字，无需继续遍历
            // 这里实际上会直接走到回溯逻辑
            if (resultSize >= 2 && num > res.get(resultSize - 1) + res.get(resultSize-2)){
                break;
            }
            // 结果集数量不足2，直接加入结果集
            // 结果集前两位数字，与当前数字，满足斐波那契数列性质，继续计算
            if (resultSize <= 1 || num == res.get(resultSize - 1) + res.get(resultSize-2)){
                // 当前数字加入结果集
                res.add((int)num);
                // 递归, 下一次dfs从i+1位置开始获取数字
                if (dfs(chars, res, i+1)){
                    // 这里没有实际业务含义，仅作为dfs成功的判断，
                    return true;
                }
                // 回溯逻辑，当前i无法获取到合法数字，取消42行add的值，同时这个逻辑只可能从18行走到这里
                res.remove(res.size() - 1);


            }
        }
        return false;
    }

    public long getDigit(char[] chars, int start, int end){
        long res = 0;
        for (int i = start; i < end; i++){
            res = res * 10 + (chars[i] - '0');
        }
        return res;
    }

    public static void main(String[] args) {
        Solution842 solution842 = new Solution842();
        List<Integer> result = solution842.splitIntoFibonacci("11235813");
        result.forEach(x-> System.out.println(x));
    }
}
