package solution.solution100_200;

import java.util.*;

public class Solution140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // 缓存，以遍历s的下标为key
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        // 第0位下标的结果集就是答案
        // wordDict去重
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<String>(wordDict), 0, map);
        List<String> breakList = new LinkedList<String>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    // 以第index下标位标准位, 计算第index位置的结果
    public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new LinkedList<List<String>>();
//             这里是处理边界情况，当遍历到字符串最后时，加入一个空白list，使得在前一个递归返回后，单词可以累加
//            if (index == length) {
//                wordBreaks.add(new LinkedList<String>());
//            }
            for (int i = index + 1; i <= length; i++) {
                // 从当前位置右移i个位置，得到一个单词
                String word = s.substring(index, i);
                // 如果该单词在输入字典中
                if (wordSet.contains(word)) {
                    // 以右移的位置为标准位，递归计算
                    // 递归方法的结果集会越来越小
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                    // 如果上面临界情况没有处理，这里再做一次保护
                    if (nextWordBreaks.size() == 0){
                        nextWordBreaks.add(new LinkedList<String>());
                    }
                    for (List<String> nextWordBreak : nextWordBreaks) {

                        LinkedList<String> wordBreak = new LinkedList<String>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            // 记录当前位置的合法词汇表，缓存
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }

    public static void main(String[] args) {
//        String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
//        String[] wordDict = {"apple", "pen", "applepen", "pine", "pineapple"};
        // 这是个极端情况
        String[] wordDict = {"a", "aa", "aaa", "aaaa", "aaaaa"};
        Solution140 solution140 = new Solution140();
//        List<String> result = solution140.wordBreak("catsanddog", Arrays.asList(wordDict));
//        List<String> result = solution140.wordBreak("pineapplepenapple", Arrays.asList(wordDict));
        List<String> result = solution140.wordBreak("aaaaaaaaaaa", Arrays.asList(wordDict));
        for (String s:result){
            System.out.println(s);
        }

    }


}
