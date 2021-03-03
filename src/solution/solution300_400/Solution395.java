package solution.solution300_400;

import solution.solution100_200.Solution105;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.max;

public class Solution395 {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        HashMap<Character, Integer> counter = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : counter.keySet()) {
            if (counter.get(c) < k) {
                int res = 0;
                for (String t : s.split(String.valueOf(c))) {
                    res = max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        return s.length();
    }

    public int longestSubstring2(String s, int k) {
        // 遍历获取每个字符的个数，用于判断是否小于k
        HashMap<Character, Integer> m = new HashMap();
        for (int i = 0; i < s.length(); i++)
        {
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        }

        // 遍历把字符串按照小于k的数量拆分成多段，分开来解决
        List<Integer> splits = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; ++i)
        {
            if (m.get(s.charAt(i)) < k)
            {
                splits.add(i);
            }
        }

        // 无需拆分，则返回整段字符串
        if (splits.size() <= 0)
        {
            return s.length();
        }

        // 返回最大长度
        int res = 0;
        int left = 0;
        for (int i = 0; i < splits.size(); i++)
        {
            // 长度不包含这个split无效字符
            int len = splits.get(i) - left;
            // 至少要大于k，否则肯定是不满足的
            if (len >= k && len > res)
            {
                // cout << "len:" << len << " " << splits[i] << endl;
                // 继续去找子串里最大值
                res = Math.max(res, longestSubstring(s.substring(left, left+len), k));
            }
            left = splits.get(i) + 1;
        }
        // 考虑最后一段没考虑的情况
        if (left < n-1)
        {
            res = Math.max(res, longestSubstring(s.substring(left, n), k));
        }

        return res;
    }


    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;
        Solution395 solution395 = new Solution395();
        System.out.println(solution395.longestSubstring2(s,k));
    }
}
