package solution.solution401_500;

import java.util.Stack;

public class Solution403 {
    public String removeKdigits(String num, int k) {
        if (k == 0){
            return num;
        }
        if (k == num.length()){
            return "0";
        }
        Stack<Character> characterStack = new Stack<>();
        String result = "";
        for(Character c: num.toCharArray()){
            if (k > 0){
                if (characterStack.empty()){
                    characterStack.push(c);
                    continue;
                }
                int peekNum = characterStack.peek() - 48;
                int currentNum = c - 48;
                while (currentNum < peekNum && k > 0 && characterStack.size() > 0){
                    characterStack.pop();
                    k--;
                    if (characterStack.empty()){
                        break;
                    }
                    peekNum = characterStack.peek() - 48;
                }
                characterStack.push(c);
            }else{
                result = result + c.toString();
            }
        }
        while(!characterStack.empty()){
            Character c= characterStack.pop();
            if (k <= 0){
                result = c.toString()+ result;
            }
            k--;
        }

        int countOfZeroAhead = 0;
        for (Character c : result.toCharArray()){
            if (c == 48){
                countOfZeroAhead++;
            }else {
                break;
            }
        }

        result = result.substring(countOfZeroAhead);
        return result.length() == 0 ? "0" : result;
    }

    public static void main(String[] args) {
        String input = "112";
        int k = 1;
        Solution403 solution403 = new Solution403();
        String result = solution403.removeKdigits(input, k);
        System.out.println(result);
    }
}
