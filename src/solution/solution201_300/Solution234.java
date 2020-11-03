package solution.solution201_300;

import bean.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
//        Stack<ListNode> stack = new Stack<>();
//
//        ListNode current = head;
//        while (current != null){
//            if (stack.size() > 0){
//                ListNode top = stack.peek();
//                if (top.val == current.val){
//                    stack.pop();
//                }else{
//                    stack.push(current);
//                }
//            }else{
//                stack.push(current);
//            }
//            current = current.next;
//        }

        List<Integer> integers = new ArrayList<>();
        ListNode current = head;
        while (current != null){
            integers.add(current.val);
            current = current.next;
        }
        int i = 0, j = integers.size() -1;
        while(i < j){
            if (!integers.get(i).equals(integers.get(j)) ){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args){
        Solution234 solution234 = new Solution234();
        ListNode node = new ListNode(-129);
        node.next = new ListNode(-129);
        boolean result = solution234.isPalindrome(node);
        System.out.println(result);

    }
}
