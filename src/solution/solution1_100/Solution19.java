package solution.solution1_100;

import bean.ListNode;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = head;
        ListNode current = head;
//        if (head.next == null){
//            if(n == 0) return head;
//            if(n == 1) return null;
//        }
        for(int i = 0; i < n; i ++){
            current = current.next;
        }
        // current为null 说明 n == 链表长度, 也就是删除链表开头即可
        if (current == null){
            return  head.next;
        }
        while(current.next != null){
            current = current.next;
            result = result.next;
        }
        result.next = result.next.next;
        return head;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        int n = 1;
        Solution19  solution19 = new Solution19();
        ListNode r = solution19.removeNthFromEnd(node, n);
        System.out.println(111);
    }
}
