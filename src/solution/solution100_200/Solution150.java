package solution.solution100_200;

import java.util.Stack;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s: tokens){
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                Integer last1 = stack.pop();
                Integer last2 = stack.pop();
                switch (s){
                    case "+": stack.push(last1 + last2); break;
                    case "-": stack.push(last2 - last1); break;
                    case "*": stack.push(last2 * last1); break;
                    case "/": stack.push(last2 / last1); break;
                    default:continue;
                }
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        Solution150 solution150 = new Solution150();
        solution150.evalRPN(tokens);
    }
}
