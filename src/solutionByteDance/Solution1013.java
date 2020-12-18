package solutionByteDance;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution1013 {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : paths){
            if (s.equals("") || s == null){
                continue;
            }
            if (s.equals(".")){
                continue;
            }
            if (s.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(s);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        List<String> resultList = new ArrayList<>();
        while(!stack.isEmpty()){
            resultList.add("/" + stack.pop());
        }
        if (resultList.size() == 0){
            return "/";
        }
        for (int i = resultList.size() - 1; i >= 0; i--){
            stringBuffer.append(resultList.get(i));
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
//        String s = "/a/./b/..////../c/";
        String s = "/home//foo/";
        Solution1013 solution1013 = new Solution1013();
        System.out.println(solution1013.simplifyPath(s));
    }
}
