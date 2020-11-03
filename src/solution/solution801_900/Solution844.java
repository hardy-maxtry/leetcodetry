package solution.solution801_900;

import java.util.Stack;

public class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        char[] ss = S.toCharArray();
        char[] tt = T.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (Character c : ss){
            if (stack.isEmpty() && c.equals('#') ){
                continue;
            }
            if (c.equals('#')){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        Stack<Character> stack2 = new Stack<>();
        for (Character c : tt){
            if (stack2.isEmpty() && c.equals('#') ){
                continue;
            }
            if (c.equals('#')){
                stack2.pop();
            }else {
                stack2.push(c);
            }
        }
        if (stack.size() != stack2.size()){
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        while (!stack2.isEmpty()){
            stringBuilder2.append(stack2.pop());
        }
        return stringBuilder2.toString().equals(stringBuilder.toString());
    }
}
