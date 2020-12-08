package solution.solution300_400;

import java.util.ArrayList;
import java.util.List;

/**
 * 与id842联动
 */
public class Solution306 {
    public boolean isAdditiveNumber(String num) {
        List<String> result = new ArrayList<>();
        return dfs(num.toCharArray(), result, 0);
    }

    public boolean dfs(char[] chars, List<String> res, int index){
        if (chars.length == index && res.size() >= 3){
            return true;
        }
        for (int i = index; i < chars.length; i++){
            // 允许数字为0，但是不允许数字以0开头
            if (chars[index] == '0'&& i > index){
                break;
            }

            long num = getDigit(chars, index, i+1);
//            if (num > Integer.MAX_VALUE){
//                break;
//            }
            int resSize = res.size();
            if (resSize >= 2 && num > Long.parseLong(res.get(resSize-1)) + Long.parseLong(res.get(resSize-2)) ){
                break;
            }

            if (resSize <= 1 ||  num == Long.parseLong(res.get(resSize-1)) + Long.parseLong(res.get(resSize-2)) ){
                res.add( new Long(num).toString());
                if (dfs(chars, res, i+1)){
                    return true;
                }
                res.remove(res.size()-1);
            }
        }
        return false;
    }

    public long getDigit(char[] chars, int start, int end){
        long res = 0L;
        for (int i = start; i < end; i++){
            res = res * 10 + (chars[i]-'0');
        }
        return res;
    }

    public static void main(String[] args) {
        Solution306 solution306 = new Solution306();
        solution306.isAdditiveNumber("121474836472147483648");
    }
}
