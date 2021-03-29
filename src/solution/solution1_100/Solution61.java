package solution.solution1_100;

import bean.ListNode;

public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0){
            return head;
        }
        int length = 1;
        ListNode pre = new ListNode(0);
        ListNode current = head;
        while (current.next != null){
            length++;
            current = current.next;
        }
        if (length <= 1 || k % length == 0){
            return head;
        }
        // 构成环
        current.next = head;
        int offset = k % length;
        current = head;
        // 举例，右移2格，相当于将尾端2格挪到链表头部
        offset = length - offset;
        while(offset > 1){
            current = current.next;
            offset--;
        }
        ListNode result = current.next;
        current.next = null;
        return result;

    }

    public static void main(String[] args) {
        int[] in = {1,2,3,4,5};
        ListNode head = ListNode.build(in);
        Solution61 solution61 = new Solution61();
        solution61.rotateRight(head, 2);
    }
}
