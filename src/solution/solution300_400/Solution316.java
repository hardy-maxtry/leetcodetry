package solution.solution300_400;

import java.util.Stack;

public class Solution316 {
    public String removeDuplicateLetters(String s) {
        // 计算每个字母出现次数
        int[] charExisted2 = new int[26];
        for (char c : s.toCharArray()){
            charExisted2[c-'a']++;
        }
        // 出现情况按顺序压栈
        Stack<Character> charStack = new Stack<>();
        int[] charExistedInStack = new int[26];
        for (char c : s.toCharArray()){
            // 栈为空
            // 当前字母直接压栈，字母剩余数量-1，字母在栈内存在次数+1
            if (charStack.isEmpty()){
                charStack.push(new Character(c));
                charExisted2[c-'a']--;
                charExistedInStack[c-'a']++;
                continue;
            }
            // 字母已经在栈内
            // 当前字母不压栈，字母剩余数量-1
            if (charExistedInStack[c-'a']>0){
                charExisted2[c-'a']--;
                continue;
            }
            // 字母不在栈内
            // 找到栈顶元素
            char peekChar = charStack.peek().charValue();
            // 栈不为空 且 栈顶字母顺序在当前字母之后 且 栈顶字母在原始字母中还有剩余存在数量，可以将栈顶元素丢弃，以保证顺序
            while(!charStack.isEmpty() && peekChar > c  && charExisted2[peekChar-'a'] > 0){
                charStack.pop();
                // 栈顶元素在栈内出现次数-1
                charExistedInStack[peekChar-'a']--;
                if (!charStack.isEmpty()){
                    peekChar = charStack.peek().charValue();
                }
            }
            // 当前字母压栈，字母剩余数量-1，字母在栈内存在次数+1
            charStack.push(new Character(c));
            charExisted2[c-'a']--;
            charExistedInStack[c-'a']++;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!charStack.isEmpty()){
            stringBuffer.append(charStack.pop());
        }
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        Solution316 solution316 = new Solution316();
        System.out.println(solution316.removeDuplicateLetters("bcabc"));
    }
}
