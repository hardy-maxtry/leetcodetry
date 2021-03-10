package solution.solution201_300;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution224 {
    public int calculate(String s) {
        int result = 0;
        int currentNum = 0;
        // -(-2 + 1) + 10 - (1+3)
        Stack<String> numStack = new Stack<>();
        Stack<Character> iconStack = new Stack<>();

        Map<Character ,Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put(')', 3);
        map.put('(', 3);
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (c.equals(' ')){
                continue;
            }else if(c.equals('+') || c.equals('-') || c.equals('*') || c.equals('/')){
                boolean find = false;
                while(!find ){
                    if (iconStack.isEmpty() || iconStack.peek().equals('(')){
                        iconStack.push(c);
                        find = true;
                    }else if(map.get(c) > map.get(iconStack.peek())){
                        iconStack.push(c);
                        find = true;
                    }else{
                        numStack.push(iconStack.pop().toString());
                    }
                }
            }else if(c.equals('(')){
                iconStack.push(c);
            }else if(c.equals(')')){
                while(!iconStack.peek().equals('(')){
                    numStack.push(iconStack.pop().toString());
                }
                iconStack.pop();
            }else {
                int tmpNum = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i)) ){
                    tmpNum = tmpNum * 10 + (s.charAt(i) - '0');
                    i++;
                }
                numStack.push(Integer.valueOf(tmpNum).toString());
                i--;
            }
        }
        while (!iconStack.isEmpty()){
            numStack.push(iconStack.pop().toString());
        }
        String newStr = "";
        Stack<String> stack2 = new Stack<>();
        while(!numStack.isEmpty()){
            stack2.push(numStack.pop());
        }
        Stack<String> stack3 = new Stack<>();
        while(!stack2.isEmpty()){
            if (map.containsKey(stack2.peek().charAt(0))){
                String c = stack2.pop();
                Integer num2 = Integer.parseInt(stack3.pop());
                Integer num1 = Integer.parseInt(stack3.pop());
                Integer tmpResult=0;
                if(c.equals("+")){
                    tmpResult= num1+num2;
                }else
                if(c.equals("-")){
                    tmpResult= num1-num2;
                }else
                if(c.equals("*")){
                    tmpResult= num1*num2;
                }else
                if(c.equals("/")){
                    tmpResult= num1/num2;
                }
                stack3.push(Integer.valueOf(tmpResult).toString());
            }else{
                stack3.push(stack2.pop());
            }
        }
        result = Integer.parseInt(stack3.pop());
        return result;
    }

    public static void main(String[] args) {
        Solution224 solution224 = new Solution224();
//        String s = "1+((2+3)*4)-5";
        String s = "42";
        Integer result = solution224.calculate(s);
        System.out.println(result);
    }
}
