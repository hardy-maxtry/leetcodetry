package solution.solution100_200;

import java.util.*;

public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        wordSet.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);



        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                // 依次遍历当前队列中的单词
                String currentWord = queue.poll();
                // 如果 currentWord 能够修改 1 个字符与 endWord 相同，则返回 step + 1
                if (changeWordEveryOneLetter(currentWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;



    }

    private boolean changeWordEveryOneLetter(String currentWord, String endWord,
                                             Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            // 先保存，然后恢复
            char originChar = charArray[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == originChar) {
                    continue;
                }
                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        // 注意：添加到队列以后，必须马上标记为已经访问
                        visited.add(nextWord);
                    }
                }
            }
            // 恢复
            charArray[i] = originChar;
        }
        return false;
    }


}
