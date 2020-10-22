package solution.solution700_800;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {
    public List<Integer> partitionLabels(String S) {
        int[] chars = new int[26];
        // 找到每个字母的最大位置，并记录
        for(int i = 0; i<S.length(); i++){
            chars[ S.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<Integer>();
        int left = 0, right = 0;
        for (int i = 0; i< S.length(); i++){
            // 找到当前字母记录到的最大位置
            // 如果当前字母最大位置大于已有right，则覆盖right
            right = Math.max(right, chars[S.charAt(i) - 'a']);
            // 如果最大位置和遍历下标相同，表明该字母左侧的所有字母的最大位置都小于等于下标
            // 如果存在一个最大位置大于当前下标的字母，则应该在之前就已经覆盖right，与现在遍历到的下标位置==right相矛盾
            if (i == right){
                result.add(right-left+1);
                left = right+1;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution763 solution763 = new Solution763();
        List<Integer> r = solution763.partitionLabels("aaabbbcccaad");
        r = solution763.partitionLabels("abcd");
        r = solution763.partitionLabels("");
        System.out.println("aaa");

    }
}
